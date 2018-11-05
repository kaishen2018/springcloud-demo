package com.softtek.irain.controller;


import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/api/v1")
@RestController
@Api("StoreController 相关的接口")
public class StoreController {

    Logger logger = LoggerFactory.getLogger(StoreController.class);

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    RestTemplate restTemplate;

    /**
     * 获取stores列表
     * @return stores列表
     */
    @GetMapping("/stores")
    public String findStore(){
        int id = discoveryClient.getOrder();
        //打印服务的服务id
        logger.info("service id *********" + id);
        return "hello,this is stores-service";
    }


    @GetMapping("/users/list")
    public String findUsers(){
        String result = restTemplate.getForObject("http://user-service/users", String.class);
        logger.info("result from user-service app {}", result);
        return "Complete calling from user-service: " + result;
    }

}
