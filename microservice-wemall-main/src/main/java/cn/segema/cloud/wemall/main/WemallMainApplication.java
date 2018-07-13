package cn.segema.cloud.wemall.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"cn.segema.cloud"})
public class WemallMainApplication {
  public static void main(String[] args) {
    SpringApplication.run(WemallMainApplication.class, args);
  }
}
