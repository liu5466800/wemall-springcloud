package cn.segema.cloud.wemall.main.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class WechatLoginInterceptor implements HandlerInterceptor {
	
	public static final String AUTHORIZE_URL = "https://open.weixin.qq.com/connect/oauth2/authorize" + "?appid={appid}"
			+ "&redirect_uri={redirecturi}" + "&response_type=code" + "&scope=snsapi_userinfo"
			+ "&state=235#wechat_redirect";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle:");
		
		
		
		
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		System.out.println("postHandle:");
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		System.out.println("afterCompletion:");
		
	}

}
