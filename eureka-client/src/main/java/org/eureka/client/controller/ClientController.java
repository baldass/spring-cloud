package org.eureka.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
	@Value("${server.port}")
	private String port;

	@RequestMapping("/")
	public String home(@RequestParam(value = "name", defaultValue = "陌生人") String name) {
		return "你好 " + name + " ,我是来自端口号:" + port;
	}
}
