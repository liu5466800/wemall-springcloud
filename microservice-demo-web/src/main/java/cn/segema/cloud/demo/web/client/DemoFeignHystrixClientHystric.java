package cn.segema.cloud.demo.web.client;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class DemoFeignHystrixClientHystric  implements DemoFeignHystrixClient{

	@Override
	public Map findDemoById(Long id) {
		Map map = new HashMap<String,String>();
		map.putIfAbsent("k1", "this is error message");
		return map;
	}

}
