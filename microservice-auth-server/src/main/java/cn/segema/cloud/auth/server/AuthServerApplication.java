package cn.segema.cloud.auth.server;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
	
/**
 * @author wangyong
 */
@SpringBootApplication
@EnableEurekaClient
@EnableAuthorizationServer
public class AuthServerApplication {
  public static void main(String[] args) {
    SpringApplication.run(AuthServerApplication.class, args);
  }
 
  @Autowired
  private AuthenticationProvider authenticationProvider;

  @Bean
  public AuthenticationManager authenticationManager() {
      return new ProviderManager(Arrays.asList(authenticationProvider));
  }
  
}
