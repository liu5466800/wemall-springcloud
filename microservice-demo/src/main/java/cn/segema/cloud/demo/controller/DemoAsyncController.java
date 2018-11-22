package cn.segema.cloud.demo.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.segema.cloud.demo.async.AsyncTask;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/demo/async")
public class DemoAsyncController {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AsyncTask asyncTask;

	@ApiOperation(value = "異步任務", notes = "異步任務")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "SonarUrl表ID", required = true, dataType = "Long", paramType = "path") })
	@GetMapping("/{id}")
	public Map findById(@PathVariable Long id) throws InterruptedException, ExecutionException {
		for (int i = 0; i < 100; i++) {
			asyncTask.doTask1(i);
		}
		logger.info("All tasks finished.");

		Map map = new HashMap<String, String>();
		map.put("key1", "value1");
		map.put("key2", "value2");
		map.put("key3", "value3");
		return map;
	}

}
