package cn.segema.cloud.demo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.segema.cloud.demo.domain.DemoTime;
import cn.segema.cloud.demo.repository.DemoTimeRepository;

@RestController
@RequestMapping(value = "/demo/time")
public class DemoTimeController {

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private DemoTimeRepository demoTimeRepository;

	@GetMapping("/{userId}")
	public Optional<DemoTime> findById(@PathVariable String userId) {
		Optional<DemoTime> findOne = demoTimeRepository.findById(userId);
		Date today = new Date();
		today.getTime();
		return findOne;
	}

	@PostMapping("/add")
	public DemoTime add(DemoTime demoTime) {
		DemoTime demo = new DemoTime();
		demo.setUserName("todayname");
		demoTimeRepository.save(demo);
		System.out.println("------time:----------");
		return demo;
	}

	@GetMapping(value = "/category")
	public ResponseEntity getMovieCategory() {
		Locale locale = LocaleContextHolder.getLocale();
		Map<Integer, String> kindsMap = new HashMap<>(16);
		Integer code = Integer.valueOf(messageSource.getMessage("register.success.code", null, locale));
		String message = messageSource.getMessage("register.success.message", null, locale);
		kindsMap.put(code, message);
		return new ResponseEntity(kindsMap, HttpStatus.BAD_REQUEST);
	}

}
