# SpringCloud学习

## 步骤
### 1. 生成maven主工程,控制依赖版本
	创建一个maven项目,按照/pom.xml修改pom.xml文件
	这个主工程起到依赖版本控制的作用,其他module工程继承该pom

### 2. 生成服务注册中心和服务提供者
	服务注册中心在分布式系统中大量应用,是分布式系统中不可或缺的组件
	服务注册中心,用来管理服务提供者(供应商)和服务消费者(消费者)的。给消费者提供可供调用的供应商列表,消费者在进行远程服务调用时,  
	根据供应商列表然后选择供应商的服务地址进行服务调用。	
	2.1. 创建服务注册中心(Eureka Server)
		2.1.1.	右键主工程创建maven的model项目,填写相关参数(model name等)
		2.1.2.	按照/eureka-server/pom.xml修改新生成的注册中心项目的pom.xml文件
		2.1.3.	按照/eureka-server/src/main/java/org/eureka/server/EurekaServerApplication.java修改项目的启动类
		2.1.4.	按照/eureka-server/src/main/resources/application.yml修改配置文件
		2.1.5.	完成上述操作之后可以通过浏览器输入网址http://localhost:8761 访问eureka server界面,里面会显示已经在这个server上注  
		册的服务,因为我们还没有注册任何服务所以显示的是No instances available
	2.2. 创建服务提供者(Eureka Client)
		2.2.1.	右键主工程创建maven的model项目,填写相关参数(model name等)
		2.2.2.	按照/eureka-client/pom.xml修改新生成的注册中心项目的pom.xml文件
		2.2.3.	按照/eureka-client/src/main/java/org/eureka/server/EurekaServerApplication.java修改项目的启动类
		2.2.4.	按照/eureka-client/src/main/resources/application.yml修改配置文件
### 3. eureka是一个高可用的组件,它没有后端缓存,每一个实例注册之后需要向注册中心发送心跳(因此可以在内存中完成),在默认情况下erureka  
	server也是一个eureka client ,必须要指定一个server

