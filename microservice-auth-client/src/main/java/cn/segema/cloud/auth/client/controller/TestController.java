package cn.segema.cloud.auth.client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class TestController {
	@GetMapping("/demo")
    public String getDemo(){
        return "good";
    }
	
	@GetMapping("/test2")
    public String test2(){
        return "test2";
    }
}
