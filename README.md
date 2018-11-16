# 项目简介
本项目是springcloud微商销售服务平台：

内容主要包含：

| 微服务角色                 | 对应的技术选型                              |
| ------------------------------------------------------- |
| 注册中心                     | Eureka                                    |
| 监控中心                     | Hystrix Dashboard                         |
| 服务提供者                 | spring mvc、spring-data-jpa、mysql等                        |
| 服务消费者                 | Ribbon/Feign消费服务提供者的接口                                                  |
| 熔断器                         | Hystrix，包括Hystrix Turbine                |
| 配置服务                     | Spring Cloud Config Server                |
| API网关                    | Spring Cloud Gateway                      |
| 服务鉴权                     | spring security                           |
# 准备

## 环境准备：

| 工具    | 版本或描述            |
| ----- | --------------------- |
| JDK   | 1.8                   |
| IDE   | STS 或者 IntelliJ IDEA |
| Maven | 3.5.2 +               |

## 主机名配置：

| 主机名配置（C:\Windows\System32\drivers\etc\hosts文件） |
| ---------------------------------------- |
| 127.0.0.1 discovery peer1 peer2 config gateway demo filecenter system |

## 主机规划：

| 项目名称                                     | 端口   | 描述                     | URL             |
| ---------------------------------------- | ---- | ---------------------------- | --------------- |
| microservice-gateway                     | 8040 | API Gateway                   |                |           
| microservice-config                      | 8050 | 配置服务                       |                 |
| microservice-discovery                   | 8761 | 注册中心                       | /               |
| microservice-monitor                     | 8060 | hystrix-Dashboard监控                                     |  |
| microservice-demo                        | 9090 | 实例demo服务                    | /1              |
| microservice-demo-web                    | 9091 | 实例demo服务WEB                 | /1              |
| microservice-filecenter                  | 6060 | 文件中心服务                    | /1               |
| microservice-sso-server                  | 9999 | SSO认证服务提供者               | /1               |
| microservice-sso-client1                 | 8080 | SSO客户端测试1                  | /1               |
| microservice-sso-client2                 | 8081 | SSO客户端测试2                  | /1               |
| microservice-system                      | 12000 | 系统管理服务                    | /1              |
| microservice-system-web                  | 12001 | 系统管理服务WEB                 | /1              |
| microservice-mall                        | 13000 | 商品管理服务提供者               | /1              |
| microservice-wemall-web                  | 13001 | 微商平台前端主入口WEB    | /1              |

在线学习地址：
https://ke.qq.com/user/index/index.html#/plan/cid=260513&tid=100307171&term_id=100307171
