package cn.segema.cloud.auth.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		super.configure(http);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// 解决静态资源被拦截的问题
		web.ignoring().antMatchers("/plugins/**").antMatchers("/favor.ico");
	}

}
