package cn.segema.cloud.sso.client2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class TestController {
	
	@GetMapping("/index")
    public ModelAndView index(){
		return new ModelAndView("index");
    }
	
	@GetMapping("/test2")
    public String test2(){
        return "test2";
    }
}
