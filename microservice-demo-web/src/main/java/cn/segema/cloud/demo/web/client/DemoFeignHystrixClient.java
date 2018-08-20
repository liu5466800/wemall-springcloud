package cn.segema.cloud.demo.web.client;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="microservice-demo",fallback = DemoFeignHystrixClientHystric.class)
public interface DemoFeignHystrixClient {
	
	@RequestMapping(value="/demo/{id}",method=RequestMethod.GET)
	public Map findDemoById(@PathVariable("id") Long id);

}
