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

import cn.segema.cloud.common.constants.OptionConstant;
import cn.segema.cloud.common.constants.RedisCacheConstant;
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
		//applicationContext 没有parent，他就是老大.
		if (event.getApplicationContext().getParent() == null) {
			System.out.println("需要执行的逻辑代码");
		}
		 HashOperations<String, Object, Object>  optionHash = redisTemplate.opsForHash();
		 Map<String,Object> optionMap = new HashMap<String,Object>();
		List<Option> optionList = optionRepository.findOptionList();
		if(optionList!=null&&optionList.size()>0) {
			for(Option option:optionList) {
				optionMap.put(option.getOptionKey(), option.getOptionValue());
			}
		}
		optionHash.putAll(RedisCacheConstant.REDIS_OPTION_MAP, optionMap);
		//取出值示例：
//		 HashOperations<String, Object, Object>  optionHash2 = redisTemplate.opsForHash();
//		 String keyValue = (String) optionHash2.get(RedisCacheConstant.REDIS_OPTION_MAP, OptionConstant.OPTION_WEB_DOMAIN);
//	     System.out.println("option_web_domain:"+keyValue);
	}

}
