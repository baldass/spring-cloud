

### 各类注解的作用
#### @EnableDiscoveryClient和@EnableEurekaClient
	两者都是能够让注册中心能够发现，扫描到本服务。
	@EnableEurekaClient只适用于Eureka作为注册中心。
	@EnableDiscoveryClient可以是其他注册中心。
	从Spring Cloud Edgware开始，@EnableDiscoveryClient 或@EnableEurekaClient 可省略。只需加上相关依赖，并进行相应配置，即可将微服务注册到服务发现组件上。
