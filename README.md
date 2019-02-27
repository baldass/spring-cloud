# SpringCloud学习

## 步骤
### 1.生成maven主工程,控制依赖版本
	创建一个maven项目,按照/pom.xml修改pom.xml文件
### 2.生成服务注册中心和服务提供者
	* 2.1 创建服务注册中心(Eureka Server)
		* 2.1.1	右键主工程创建maven的model项目,填写相关参数(model name等)
		* 2.1.2	按照/eureka-server/pom.xml修改新生成的注册中心项目的pom.xml文件
		* 2.1.3	按照/eureka-server/src/main/java/org/eureka/server/EurekaServerApplication.java修改项目的启动类
		* 2.1.4	按照/eureka-server/src/main/resources/application.yml修改配置文件
	*2.2 创建服务提供者(Eureka Client)
		* 2.2.1	右键主工程创建maven的model项目,填写相关参数(model name等)
		* 2.2.2	按照/eureka-client/pom.xml修改新生成的注册中心项目的pom.xml文件
		* 2.2.3	按照/eureka-client/src/main/java/org/eureka/server/EurekaServerApplication.java修改项目的启动类
		* 2.2.4	按照/eureka-client/src/main/resources/application.yml修改配置文件
#### eureka是一个高可用的组件,它没有后端缓存,每一个实例注册之后需要向注册中心发送心跳(因此可以在内存中完成),<br>在默认情况下erureka server也是一个eureka client ,必须要指定一个server

