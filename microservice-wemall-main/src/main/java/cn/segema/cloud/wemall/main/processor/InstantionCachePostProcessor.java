package cn.segema.cloud.wemall.main.processor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import cn.segema.cloud.system.domain.Option;
import cn.segema.cloud.system.domain.User;
import cn.segema.cloud.system.repository.OptionRepository;
import cn.segema.cloud.system.repository.UserRepository;

@Component
public class InstantionCachePostProcessor implements ApplicationListener<ContextRefreshedEvent> {

	@Resource
	private StringRedisTemplate stringRedisTemplate;

	@Resource
	private RedisTemplate redisTemplate;
	
	@Resource
	private OptionRepository optionRepository;
	
	@Resource
	private UserRepository userRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// root application context 没有parent，他就是老大.
		if (event.getApplicationContext().getParent() == null) {
			// 需要执行的逻辑代码，当spring容器初始化完成后就会执行该方法。
			System.out.println("需要执行的逻辑代码");
		}
		System.out.println("外面" + event.getApplicationContext().getParent());
		ValueOperations<String, String> valueOps = stringRedisTemplate.opsForValue();
		
		 HashOperations<String, Object, Object>  optionHash = redisTemplate.opsForHash();
		 Map<String,Object> optionMap = new HashMap<String,Object>();
		List<Option> optionList = optionRepository.findOptionList();
		
		 List<User> userList = userRepository.findAllUser();
		
		if(optionList!=null&&optionList.size()>0) {
			for(int i=0;i<optionList.size();i++) {
				Option option = optionList.get(i);
				optionMap.put(option.getOptionKey(), option.getOptionValue());
			}
//			for(Option option:optionList) {
//				optionMap.put(option.getOptionKey(), option.getOptionValue());
//			}
		}
		optionHash.putAll("optionMap", optionMap);
		 
		ValueOperations<String, String> valueOps2 = stringRedisTemplate.opsForValue();
	     System.out.println("oauth2_wechat_appkey:"+valueOps2.get("oauth2_wechat_appkey"));

	}

}
