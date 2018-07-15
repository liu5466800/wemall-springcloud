package cn.segema.cloud.auth.server.config;

import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

@Configuration
@EnableAuthorizationServer
class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	private static final Logger logger = LoggerFactory.getLogger(AuthorizationServerConfig.class);

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private DataSource dataSource;

	@Bean
	public TokenStore tokenStore() {
		return new JdbcTokenStore(dataSource);
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager);
		endpoints.tokenStore(tokenStore());

		// 配置TokenServices参数
		DefaultTokenServices tokenServices = new DefaultTokenServices();
		tokenServices.setTokenStore(endpoints.getTokenStore());
		tokenServices.setSupportRefreshToken(false);
		tokenServices.setClientDetailsService(endpoints.getClientDetailsService());
		tokenServices.setTokenEnhancer(endpoints.getTokenEnhancer());
		tokenServices.setAccessTokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(30)); // 30天
		endpoints.tokenServices(tokenServices);
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
		oauthServer.checkTokenAccess("permitAll()");
		oauthServer.allowFormAuthenticationForClients();
	}

	@Bean
	public ClientDetailsService clientDetails() {
		return new JdbcClientDetailsService(dataSource);
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.withClientDetails(clientDetails());
		
//		 clients.inMemory() // 使用in-memory存储
//         .withClient("client") // client_id
//         .secret("secret") // client_secret
//         .authorizedGrantTypes("authorization_code") // 该client允许的授权类型
//         .scopes("app"); // 允许的授权范围
	}

}
