package cn.segema.cloud.sso.client1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class TestController {
	
	@GetMapping("/index")
    public ModelAndView index(){
		return new ModelAndView("index");
    }
	
	@GetMapping("/test1")
    public String test1(){
        return "test1";
    }
}
