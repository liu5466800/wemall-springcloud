package cn.segema.cloud.auth.client.interceptor;

import java.util.Enumeration;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class AuthLoginInterceptor implements HandlerInterceptor {

	// public static final String AUTHORIZE_URL =
	// "https://open.weixin.qq.com/connect/oauth2/authorize" + "?appid={appid}"
	// + "&redirect_uri={redirecturi}" + "&response_type=code" +
	// "&scope=snsapi_userinfo"
	// + "&state=235#wechat_redirect";

	public static final String AUTHORIZE_URL = "http://localhost:8040/oauth/authorize?client_id=client&client_secret=secret&response_type=code&redirect_uri=";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		System.out.println("preHandle:");
		
		Enumeration headers = request.getHeaders("Authorization");
		
		Cookie[] cookies = request.getCookies();
		
		String code = request.getParameter("code");
		String token = request.getParameter("access_token");
		if(code==null||("".equals(code))) {
			String toUrl = request.getRequestURI();
			String redirectUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath() + toUrl;
			response.sendRedirect(AUTHORIZE_URL + redirectUrl);
			return true;
		}else {
			return true;
		}
		
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