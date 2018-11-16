package cn.segema.cloud.system.controller;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.segema.cloud.common.page.Pager;
import cn.segema.cloud.common.page.PagerParamVO;
import cn.segema.cloud.common.utils.IdGeneratorUtil;
import cn.segema.cloud.system.domain.User;
import cn.segema.cloud.system.repository.UserRepository;
import cn.segema.cloud.system.service.UserService;
import cn.segema.cloud.system.vo.UserPersonalVO;

/**
 * 用户Controller
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	/**
	 * @param id
	 * @return user信息
	 */
	@GetMapping("/{userId}")
	public Optional<User> findById(@PathVariable BigInteger userId) throws Exception {
		Optional<User> user = this.userRepository.findById(userId);
		return user;
	}

	@GetMapping("/list")
	public List<User> list(User user, Model model) {
		List<User> userList = userRepository.findAll();
		return userList;
	}

	@PostMapping("/add")
	public User add(User user, Model model) {
		if (user.getUserId() == null) {
			user.setUserId(BigInteger.valueOf(IdGeneratorUtil.generateSnowFlakeId()));
		}
		String pass = new BCryptPasswordEncoder().encode(user.getPassword());
		user.setPassword(pass);
		userRepository.save(user);
		return user;
	}

	@RequestMapping(value = "edit")
	public User edit(User user, Model model) {
		User oldRole = userRepository.getOne(user.getUserId());
		BeanUtils.copyProperties(user, oldRole);
		userRepository.save(user);
		return user;
	}

	@RequestMapping(value = "delete")
	public User delete(User user) {
		userRepository.delete(user);
		return user;
	}

	@GetMapping("/list_personal_user_name/{userName}")
	public List<UserPersonalVO> listUserPersonalByUserName(@PathVariable String userName) {
		List<UserPersonalVO> userList = userRepository.findUserPersonalByUserName(userName);
		return userList;
	}
	
	@GetMapping("/list_nick_name/{nickName}")
	public Page<User> listByNickName(@PathVariable String nickName) {
		Sort sort = new Sort(Sort.Direction.DESC,"delete_status");
	    Pageable pageable = PageRequest.of(1, 20, sort);
	    Page<User> userList = userRepository.findByNickName(nickName,pageable);
		return userList;
	}

	@GetMapping("/list_page")
	public Pager<User> listByPage(PagerParamVO pagerParam) {
		Sort sort = new Sort(Direction.DESC, "userId");
		Pageable pageable = PageRequest.of(pagerParam.getCurr() - 1, pagerParam.getNums(), sort);
		Page<User> page = userService.findByPage(pageable, pagerParam.getParams());
		Pager<User> pager = new Pager<User>();
		pager.setCode("0");
		pager.setMsg("success");
		pager.setCount(page.getTotalElements());
		pager.setData(page.getContent());
		return pager;
	}
	
	

}
