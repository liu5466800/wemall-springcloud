package cn.segema.cloud.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableCircuitBreaker
@EnableFeignClients
@EnableEurekaClient
public class SystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(SystemApplication.class,args);
	}
}
