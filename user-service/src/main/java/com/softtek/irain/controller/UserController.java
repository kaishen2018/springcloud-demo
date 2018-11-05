package com.softtek.irain.controller;


import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1")
@RestController
@Api("UserController 相关的接口")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    DiscoveryClient discoveryClient;

    /**
     * 获取用户列表
     * @return 用户列表
     */
    @GetMapping("/users")
    public String findUsers(){
        int id = discoveryClient.getOrder();
        //打印服务的服务id
        logger.info("service id *********" + id);
        return "hello,this is user-service";
    }

}
