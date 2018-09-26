package cn.segema.cloud.wemall.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.segema.cloud.common.page.Pager;
import cn.segema.cloud.common.page.PagerParamVO;
import cn.segema.cloud.common.utils.IdGeneratorUtil;
import cn.segema.cloud.wemall.domain.User;
import cn.segema.cloud.wemall.repository.UserRepository;

/**
 * 用户Controller
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
  @Autowired
  private DiscoveryClient discoveryClient;
  @Autowired
  private UserRepository userRepository;
  
  /**
   * @param id
   * @return user信息
   */
  @GetMapping("/{userId}")
  public Optional<User> findById(@PathVariable Long userId) throws Exception {
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
		if (user.getUserId()==0L) {
			user.setUserId(IdGeneratorUtil.generateSnowFlakeId());
		}
		userRepository.save(user);
		return user;
	}

	@RequestMapping(value = "edit")
	public User edit(User user, Model model) {
		User oldUser = userRepository.getOne(user.getUserId());
		 BeanUtils.copyProperties(user, oldUser);
		userRepository.save(user);
		return user;
	}

	@RequestMapping(value = "delete")
	public User delete(User user) {
		userRepository.delete(user);
		return user;
	}
  
  @GetMapping("/listByPage")
	public Pager<User> listByPage(PagerParamVO pagerParam) {
		Sort sort = new Sort(Direction.DESC, "userId");
		Pageable pageable = new PageRequest(pagerParam.getCurr()-1, pagerParam.getNums(), sort);
		Page<User> page = userRepository.findAll(pageable);
		Pager<User> pager = new Pager<User>();
		pager.setCode("0");
		pager.setMsg("success");
		pager.setCount(page.getTotalElements());
		pager.setData(page.getContent());
		return pager;
	}
  
}
