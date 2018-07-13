package cn.segema.cloud.wemall.main.interceptor;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import cn.segema.cloud.common.constants.OptionConstant;
import cn.segema.cloud.common.constants.RedisCacheConstant;
import cn.segema.cloud.common.constants.WechatConstant;
import cn.segema.cloud.common.utils.AuthJsApiUtil;
import cn.segema.cloud.system.domain.Option;
import cn.segema.cloud.system.repository.OptionRepository;

@Component
public class WechatLoginInterceptor implements HandlerInterceptor {
	
	public static final String AUTHORIZE_URL = "https://open.weixin.qq.com/connect/oauth2/authorize" + "?appid={appid}"
			+ "&redirect_uri={redirecturi}" + "&response_type=code" + "&scope=snsapi_userinfo"
			+ "&state=235#wechat_redirect";
	
	@Resource
	private RedisTemplate redisTemplate;
	
	@Resource
	private OptionRepository optionRepository;
	

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		 HashOperations<String, Object, Object>  optionHash = redisTemplate.opsForHash();
		 String appid = (String) optionHash.get(RedisCacheConstant.REDIS_OPTION_MAP, WechatConstant.WECHAT_APPID);
		 String appsecret = (String) optionHash.get(RedisCacheConstant.REDIS_OPTION_MAP, WechatConstant.WECHAT_APPSECRET);
		 if(appid==null||appsecret==null) {
			 Map<String,Object> optionMap = new HashMap<String,Object>();
			 List<Option> optionList = optionRepository.findOptionList();
			 if(optionList!=null&&optionList.size()>0) {
					for(Option option:optionList) {
						optionMap.put(option.getOptionKey(), option.getOptionValue());
					}
				}
				optionHash.putAll(RedisCacheConstant.REDIS_OPTION_MAP, optionMap);
				appid = (String) optionHash.get(RedisCacheConstant.REDIS_OPTION_MAP, WechatConstant.WECHAT_APPID);
				appsecret = (String) optionHash.get(RedisCacheConstant.REDIS_OPTION_MAP, WechatConstant.WECHAT_APPSECRET);
		 }
		
		// 被拦截前的请求URL
        String toUrl = request.getRequestURI();
        toUrl = toUrl.replaceAll(request.getContextPath(), "");
        //当前url
        String currUrl = request.getScheme() + "://" + 
                (request.getServerName().startsWith("1") ? request.getServerName()+":"+request.getServerPort() : request.getServerName()) + 
                request.getContextPath() + toUrl;
        toUrl = URLEncoder.encode(toUrl,OptionConstant.DEFAULT_ENCODING);
        
       // JsTicket jsTicket = JsTicketApi.getTicket(JsApiType.jsapi);
       // String jsapi_ticket = jsTicket.getTicket();
        String jsapi_ticket ="1234";
        Map<String, Object> newSignature = AuthJsApiUtil.sign(appid, jsapi_ticket, currUrl);
		
		String signature = String.valueOf(newSignature.get("signature"));
		String timestamp = String.valueOf(newSignature.get("timestamp"));
		String nonceStr =  String.valueOf(newSignature.get("nonceStr"));
		
		Object userSession = request.getSession().getAttribute(OptionConstant.SESSION_WECHAT_USER);
		
		
		String redirectUrl = request.getScheme() + "://" + (request.getServerName().startsWith("1") ? request.getServerName()+":"+request.getServerPort() : request.getServerName()) + 
		        request.getContextPath() + "/wechat/callback?goto=" + toUrl;
		redirectUrl =URLEncoder.encode(redirectUrl,OptionConstant.DEFAULT_ENCODING);
		
		String url = AUTHORIZE_URL.replace("{redirecturi}", redirectUrl).replace("{appid}", appid.trim());
		response.sendRedirect(url);
		
		return true;
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
