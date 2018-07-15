package cn.segema.cloud.auth.server.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("authorizationRequest")
public class ErrorController {

	private static final Logger log = LoggerFactory.getLogger(ErrorController.class);

	@RequestMapping("/oauth/error")
	public String error(@RequestParam Map<String, String> parameters) {
		String uri = parameters.get("redirect_uri");
		log.info("重定向: {}", uri);

		return "redirect:" + uri + "?error=1";
	}
}
