package cn.segema.cloud.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


@Configuration
public class I18nConfig extends WebMvcConfigurationSupport{
	@Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
//        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
//        sessionLocaleResolver.setDefaultLocale(Locale.SIMPLIFIED_CHINESE);
//        return  sessionLocaleResolver;
    }

}
