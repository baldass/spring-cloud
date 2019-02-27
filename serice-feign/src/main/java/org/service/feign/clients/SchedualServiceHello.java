package org.service.feign.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "eureka-client")
public interface SchedualServiceHello {
	@RequestMapping(value = "/hi",method = RequestMethod.GET)
	String sayHelloFromClient(@RequestParam(value = "name") String name);
}
