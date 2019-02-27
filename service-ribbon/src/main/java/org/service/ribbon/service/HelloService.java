package org.service.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "helloError")
	public String hiService(String name) {
		return restTemplate.getForObject("http://eureka-client/hi?name=" + name, String.class);
	}

	public String helloError(String name) {
		return "Hello ,"+name+",抱歉,这里出错了!";
	}
	/*
	@HystrixCommand注解 对又该注解的方法添加熔断器的功能
	参数fallbackMethod指定熔断方法,这里为helloError方法
	 */
}
