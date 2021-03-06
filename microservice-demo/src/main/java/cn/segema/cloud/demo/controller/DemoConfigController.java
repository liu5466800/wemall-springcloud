package cn.segema.cloud.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.segema.cloud.demo.repository.DemoRepository;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/demo/config")
public class DemoConfigController {
  private static Logger log = LoggerFactory.getLogger(DemoConfigController.class);
	
  @Autowired
  private DemoRepository demoRepository;
  
  @Value("${demo.local.directory}")
  private String demoLocalDirectory;

  @ApiOperation(value="获取项目组Sonar对应的Url信息", notes="根据id获取项目组Sonar对应的Url信息")// 使用该注解描述接口方法信息  
  @ApiImplicitParams({  
          @ApiImplicitParam(name = "id", value = "SonarUrl表ID", required = true, dataType = "Long", paramType="path")  
  })
  @GetMapping("/{id}")
  public Map findById(@PathVariable String id) {
	  Map map = new HashMap<String,String>();
	  map.put("key1", "value1");
	  map.put("key2", "value2");
	  map.put("key3", "value3");
	  map.put("demoLocalDirectory", demoLocalDirectory);
	  return map;
  }
  
  
 
}
