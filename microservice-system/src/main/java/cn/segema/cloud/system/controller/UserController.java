package cn.segema.cloud.system.controller;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.segema.cloud.common.constants.ApiConstant;
import cn.segema.cloud.common.page.Pager;
import cn.segema.cloud.common.utils.IdGeneratorUtil;
import cn.segema.cloud.system.domain.User;
import cn.segema.cloud.system.repository.UserRepository;
import cn.segema.cloud.system.vo.UserPersonalVO;
import cn.segema.cloud.system.vo.UserVO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 用户Controller
 */
@RestController
@RequestMapping(value = ApiConstant.API_VERSION + "/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@ApiOperation(value = "新增用户", notes = "新增用户")
	@PostMapping
	public User add(@RequestBody User user) {
		if (user.getUserId() == null) {
			user.setUserId(BigInteger.valueOf(IdGeneratorUtil.generateSnowFlakeId()));
		}
		String pass = new BCryptPasswordEncoder().encode(user.getPassword());
		user.setPassword(pass);
		user.setCreateTime(BigInteger.valueOf(System.currentTimeMillis()));
		userRepository.save(user);
		return user;
	}

	@ApiOperation(value = "修改用户", notes = "修改用户")
	@PutMapping
	public User edit(User user, Model model) {
		User oldRole = userRepository.getOne(user.getUserId());
		BeanUtils.copyProperties(user, oldRole);
		userRepository.save(user);
		return user;
	}

	@ApiOperation(value = "删除用户", notes = "删除用户")
	@DeleteMapping("/{userId}")
	public User delete(@PathVariable BigInteger userId) {
		Optional<User> user = userRepository.findById(userId);
		if(user!=null) {
			userRepository.delete(user.get());
		}
		return user.get();
	}

	@ApiOperation(value = "根据id获取用户", notes = "根据id获取用户")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "userId", value = "用户id", required = true, paramType = "path") })
	@GetMapping("/{userId}")
	public Optional<User> findById(@PathVariable BigInteger userId) throws Exception {
		Optional<User> user = this.userRepository.findById(userId);
		return user;
	}

	@ApiOperation(value = "根据用户名获取用户人员", notes = "根据用户名获取用户人员")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "userName", value = "用户名", required = true, paramType = "path") })
	@GetMapping("/user-personal/{userName}")
	public List<UserPersonalVO> findUserPersonalByUserName(@PathVariable String userName) {
		List<UserPersonalVO> userList = userRepository.findUserPersonalByUserName(userName);
		return userList;
	}

	@ApiOperation(value = "根据昵称获取用户", notes = "根据昵称获取用户")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "userName", value = "昵称", required = true, paramType = "path") })
	@GetMapping("/user-name/{userName}")
	public List<User> findByUserName(@PathVariable String userName) {
		List<User> userList = userRepository.findByUserName(userName);
		return userList;
	}
	
	@ApiOperation(value = "根据用户名获取用户", notes = "根据用户名获取用户")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "nickName", value = "昵称", required = true, paramType = "path") })
	@GetMapping("/nick-name/{nickName}")
	public List<User> findByNickName(@PathVariable String nickName) {
		List<User> userList = userRepository.findByNickName(nickName);
		return userList;
	}

	@ApiOperation(value = "分页获取用户", notes = "分页获取用户")
	@ApiImplicitParams({@ApiImplicitParam(name = "page", value = "当前页", required = true, paramType = "query"),
		@ApiImplicitParam(name = "limit", value = "每页数", required = true, paramType = "query"),
		@ApiImplicitParam(name = "sort", value = "排序列", required = false, paramType = "query")})
	@GetMapping("/page")
	public Pager<User> findByPage(@RequestParam(defaultValue ="1") int page, 
			@RequestParam(defaultValue = "20") int limit, 
			@RequestParam(defaultValue = "user_id") String sort,UserVO user) {
		Sort sortOrder = new Sort(Sort.Direction.DESC, sort);
		Pageable pageable = PageRequest.of(page - 1, limit, sortOrder);
		//Page<User> userPage = userRepository.findByPage(user.getUserName(),user.getGender(),pageable);
		Page<User> userPage = userRepository.findByPage(user,pageable);
		Pager<User> pager = new Pager<User>();
		pager.setCode("0");
		pager.setMsg("success");
		pager.setCount(userPage.getTotalElements());
		pager.setData(userPage.getContent());
		return pager;
	}

}
