package cn.segema.cloud.demo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

import cn.segema.cloud.demo.domain.DemoTime;
import cn.segema.cloud.demo.repository.DemoTimeRepository;
import cn.segema.cloud.demo.utils.LocaleMessageSourceUtil;

@RestController
@RequestMapping(value = "/demo/time")
public class DemoTimeController {

	@Resource
	private LocaleMessageSourceUtil localeMessage;

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

	@GetMapping("/language")
	public ResponseEntity language(HttpServletRequest request, HttpServletResponse response, String lang) {
		LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
		if ("zh".equals(lang)) {
			localeResolver.setLocale(request, response, new Locale("zh", "CN"));
		} else if ("en".equals(lang)) {
			localeResolver.setLocale(request, response, new Locale("en", "US"));
		}
		Locale locale = LocaleContextHolder.getLocale();
		return new ResponseEntity(localeMessage.getMessage("welcome",locale), HttpStatus.OK);
	}

	@GetMapping(value = "/category")
	public ResponseEntity getMovieCategory() {
		Locale locale = LocaleContextHolder.getLocale();
		Map<String, String> kindsMap = new HashMap<>(16);
		String code = localeMessage.getMessage("welcome", locale);
		String message = localeMessage.getMessage("welcome", locale);
		kindsMap.put(code, message);
		return new ResponseEntity(kindsMap, HttpStatus.BAD_REQUEST);
	}

}
