package cn.segema.cloud.shrio.controller;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.segema.cloud.shrio.repository.UserRepository;
import cn.segema.cloud.shrio.vo.UserVO;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Resource
	private UserRepository userRepository;

	// @GetMapping("/user")
	// public Principal user(Principal user){
	// return user;
	// }

	// @RequiresRoles("ADMIN")
	@RequestMapping(value = "/userlist", method = RequestMethod.GET)
	public String index(Model model) {
		// Subject currentUser = SecurityUtils.getSubject();
		// String userName = (String) currentUser.getPrincipal();
		// if (currentUser.hasRole("ADMIN")) {
		// // 拥有角色ADMIN
		// model.addAttribute("username", userName+"系统管理员");
		// }
		// if (currentUser.hasRole("NORMAL")) {
		// // 没有角色处理
		// model.addAttribute("username", userName+"普通人员");
		// }
		return "userlist";
	}

	//@RequiresRoles("AAAA")
	@RequestMapping("/list")
	@ResponseBody
	public List<UserVO> list() {
		List<UserVO> userList = new CopyOnWriteArrayList<UserVO>();
		UserVO userVO = new UserVO();
		userVO.setUserName("test");
		userVO.setNickName("nickName");
		userRepository.findByUserName("uuu");
		
		return userList;
	}

}
