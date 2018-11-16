package cn.segema.cloud.sso.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.segema.cloud.sso.server.domain.OauthClientDetails;
import cn.segema.cloud.sso.server.repository.OauthClientDetailsRepository;

@RestController
@RequestMapping("/server")
public class ServerController {

	@Autowired
	private OauthClientDetailsRepository oauthClientDetailsRepository;

	@PostMapping("/register")
    public OauthClientDetails register(String client_id,String password,String webRedirectUrl){
		
		OauthClientDetails oauthClientDetails = new OauthClientDetails();
		oauthClientDetails.setClient_id(client_id);
		oauthClientDetails.setResource_ids(null);
		oauthClientDetails.setClient_secret(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(password));
		//oauthClientDetails.setClient_secret(new BCryptPasswordEncoder().encode(password));
		oauthClientDetails.setScope("app");
		oauthClientDetails.setAuthorized_grant_types("authorization_code");
		oauthClientDetails.setWeb_server_redirect_uri(webRedirectUrl);
		oauthClientDetails.setAuthorities(null);
		oauthClientDetails.setAccess_token_validity(null);
		oauthClientDetails.setRefresh_token_validity(null);
		oauthClientDetails.setAdditional_information(null);
		oauthClientDetails.setAutoapprove(null);
		oauthClientDetailsRepository.save(oauthClientDetails);
        return oauthClientDetails;
    }

	@GetMapping("/index2")
	public String index2() {
		return "index2";
	}
}