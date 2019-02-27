package org.service.feign.controller;

import org.service.feign.clients.SchedualServiceHello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@Autowired
	SchedualServiceHello schedualServiceHello;

	@GetMapping(value = "/hi")
	public String sayHi(@RequestParam String name) {
		return schedualServiceHello.sayHelloFromClient(name);
	}
}
