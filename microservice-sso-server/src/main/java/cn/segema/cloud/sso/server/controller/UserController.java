package cn.segema.cloud.sso.server.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	private static Logger log = LoggerFactory.getLogger(UserController.class);

	@GetMapping("/user/me")
	public Principal user(Principal principal) {
		log.info("Principal:"+principal);
		return principal;
	}

}
