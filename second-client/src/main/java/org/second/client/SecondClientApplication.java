package org.second.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 第二个消费者
 *
 */
@EnableEurekaClient
@SpringBootApplication
public class SecondClientApplication {
	public static void main(String[] args) {
		SpringApplication.run(SecondClientApplication.class, args);
	}
}
