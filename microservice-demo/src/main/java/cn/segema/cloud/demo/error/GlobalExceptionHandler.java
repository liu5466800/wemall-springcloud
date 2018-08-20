package cn.segema.cloud.demo.error;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice(basePackages="cn.segema.cloud.demo.controller")
public class GlobalExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public Map<String,Object> errorResult(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("errotcode", 500);
		map.put("errotmsg", "系统错误");
		return map;
	}
}
