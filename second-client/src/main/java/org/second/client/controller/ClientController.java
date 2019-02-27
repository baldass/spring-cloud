package org.second.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
	@Value("${server.port}")
	private String port;

	@RequestMapping("/hi")
	public String home(@RequestParam(value = "name", defaultValue = "陌生人") String name) {
		return "Hello " + name + "!我的端口号是:" + port + "\r\n--来自第二个服务提供者";
	}
}
