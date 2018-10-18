package cn.segema.cloud.sso.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	
	@GetMapping("/server")
    public String server(){
        return "server";
    }
	
    @GetMapping("/index2")
    public String index2() {
        return "index2";
    }
}