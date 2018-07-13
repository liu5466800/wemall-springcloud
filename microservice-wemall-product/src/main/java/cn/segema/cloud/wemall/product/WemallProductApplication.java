package cn.segema.cloud.wemall.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class WemallProductApplication {
  public static void main(String[] args) {
    SpringApplication.run(WemallProductApplication.class, args);
  }
}
