package cn.segema.cloud.auth.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import cn.segema.cloud.auth.client.interceptor.AuthLoginInterceptor;

@Configuration
public class AuthLoginConfiguration extends WebMvcConfigurerAdapter {
	@Bean
	AuthLoginInterceptor authLoginInterceptor() {
		return new AuthLoginInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 多个拦截器组成一个拦截器链
		// addPathPatterns 用于添加拦截规则
		// excludePathPatterns 用户排除拦截
		registry.addInterceptor(authLoginInterceptor()).addPathPatterns("/**");
		// super.addInterceptors(registry);

		// .excludePathPatterns("/seengene/login")
		// .excludePathPatterns("/seengene/logindo");
	}

}
