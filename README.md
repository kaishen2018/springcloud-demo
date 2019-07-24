# Spring cloud 项目学习
> 打造成 spring boot / cloud / data 项目模板

## 参考：
- [学习链接](http://www.ityouknow.com/spring-cloud)
- [产品 - 打卡小工具](https://note.youdao.com/web/#/file/recent/markdown/WEBe6749264bfa5f534954a0b661fe033d3/)

## 目标
- [x] 服务注册与发现（基于Eureka） : part1_service-register-discovery
- [x] 客户端负载均衡（基于Ribbon） : part2_client-load-balance
- [x] 声明式REST调用（基于Feign） : part3_feign
- [x] 容错处理（基于Hystrix） : part4_hystrix
- [ ] 熔断监控Hystrix Dashboard和Turbine
- [ ] API网关（基于Zuul） : part5_zuul
- [ ] 统一配置管理（基于Spring Cloud Config） : part6_config
- [ ] 微服务跟踪（基于Spring Cloud Sleuth） : part7_sleuth
- [ ] Spring Cloud on Docker与Docker Compose编排微服务 : Java微服务之Spring Boot on Docker（Docker Compose编排Spring Cloud微服务）
- [ ] 构建打卡小工具产品
- [ ] 构建亲人圈定位产品
- [ ] 构建共享服务+物联网产品
  - [ ] 通用服务 - 用户登陆、授权
  - [ ] 通用服务 - 定位，历史轨迹
  - [ ] 通用服务 - 定单管理
  - [ ] 通用服务 - 支付管理


## 服务注册与发现（基于Eureka）
### 参考eureka 单节点 和多节点 构建
  - 参考[eureka-server](http://www.ityouknow.com/springcloud/2017/05/10/springcloud-eureka.html)

## 声明式REST调用（基于Feign）
- [spring boot2.x下 使用feign，注解@EnableFeignClients 找不到的解决方法](https://www.cnblogs.com/sxdcgaq8080/p/9860939.html)


## 系统启动方式
- 1 下载代码
- 2 安装 maven 依赖
- 3 依次启动
  - 1 eureka-server `可修改配置文件，启动多节点`
  - 2 user-service `可修改配置文件，启动多节点`
  - 3 app-server
- 4 测试
  - Eureka-server: http://localhost:8001/
  - User-service:
    - http://localhost:8081/
    - http://localhost:8082/
  - api-service:   http://localhost:9000/