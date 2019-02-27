package org.service.feign.clients.impl;

import org.service.feign.clients.SchedualServiceHello;
import org.springframework.stereotype.Component;

@Component
public class SchedualServiceHelloImpl implements SchedualServiceHello {
	@Override
	public String sayHelloFromClient(String name) {
		return "抱歉"+name+"Feign也报错了";
	}
}
