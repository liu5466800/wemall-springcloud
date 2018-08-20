package cn.segema.cloud.wemall.main.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * MainController
 */
@RestController
@RequestMapping(value = "/wemall/main")
public class MainController {
  /**
   * @param id
   * @return user信息
   */
  @GetMapping("/{userId}")
  public Map findById(@PathVariable Long userId) throws Exception {
    Map map = new HashMap<String,String>();
    return map;
  }
  
}
