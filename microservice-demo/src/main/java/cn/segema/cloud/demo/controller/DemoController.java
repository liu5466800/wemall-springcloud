package cn.segema.cloud.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.segema.cloud.demo.repository.DemoRepository;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/demo")
public class DemoController {
 
  @Autowired
  private DemoRepository demoRepository;

  @ApiOperation(value="获取项目组Sonar对应的Url信息", notes="根据id获取项目组Sonar对应的Url信息") 
  @ApiImplicitParams({  
          @ApiImplicitParam(name = "id", value = "SonarUrl表ID", required = true, dataType = "Long", paramType="path")  
  })
  @GetMapping("/{id}")
  public Map findById(@PathVariable Long id) {
	  Map map = new HashMap<String,String>();
	  map.put("key1", "value1");
	  map.put("key2", "value2");
	  map.put("key3", "value3");
	  return map;
  }
  
}
