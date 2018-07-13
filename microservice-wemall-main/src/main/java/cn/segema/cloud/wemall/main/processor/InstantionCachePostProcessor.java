package cn.segema.cloud.wemall.main.processor;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import cn.segema.cloud.system.domain.Option;
import cn.segema.cloud.system.repository.OptionRepository;

@Component
public class InstantionCachePostProcessor implements ApplicationListener<ContextRefreshedEvent> {

	@Resource
	private StringRedisTemplate stringRedisTemplate;

	@Resource
	private RedisTemplate redisTemplate;
	
	@Resource
	private OptionRepository optionRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// root application context 没有parent，他就是老大.
		if (event.getApplicationContext().getParent() == null) {
			// 需要执行的逻辑代码，当spring容器初始化完成后就会执行该方法。
			System.out.println("需要执行的逻辑代码");
		}
		System.out.println("外面" + event.getApplicationContext().getParent());
		//ValueOperations<String, String> valueOps = redisTemplate.opsForValue();
		List<Option> optionList = optionRepository.findOptionList();
		if(optionList!=null&&optionList.size()>0) {
			for(Option option:optionList) {
				redisTemplate.opsForValue().set(option.getOptionKey(),option.getOptionValue());
			}
		}
	     System.out.println("oauth2_wechat_appkey:"+redisTemplate.opsForValue().get("oauth2_wechat_appkey"));

	}

}
