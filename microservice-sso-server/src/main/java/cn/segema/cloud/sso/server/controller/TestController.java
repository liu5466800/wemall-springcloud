package cn.segema.cloud.sso.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
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