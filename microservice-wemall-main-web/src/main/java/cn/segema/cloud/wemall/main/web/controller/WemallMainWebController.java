package cn.segema.cloud.wemall.main.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.segema.cloud.wemall.main.web.service.MainWebService;
import cn.segema.cloud.wemall.main.web.vo.UserVO;

@Controller
@RequestMapping(value = "/wemall/main/web")
public class WemallMainWebController {

	@Autowired
	private MainWebService userWebService;

	@RequestMapping("/findById/{userId}")
	@ResponseBody
	public UserVO findById(@PathVariable String userId) {
		UserVO findOne = this.userWebService.findById(userId);
		return findOne;
	}
}
