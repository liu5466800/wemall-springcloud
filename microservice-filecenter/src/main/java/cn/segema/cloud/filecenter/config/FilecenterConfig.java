package cn.segema.cloud.filecenter.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(filecenterProperties.class)
public class FilecenterConfig {

}

