package cn.segema.cloud.wemall.main.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.segema.cloud.wemall.main.web.vo.UserVO;

@Controller
@RequestMapping(value = "/wemall/main/web")
public class WemallMainWebController {

	@RequestMapping("/findById/{userId}")
	@ResponseBody
	public UserVO findById(@PathVariable String userId) {
		UserVO oneUser = new UserVO();
		oneUser.setUserName("wangyong");
		oneUser.setNickName("jesse");
		oneUser.setMobileNumber("18682561280");
		return oneUser;
	}
}
