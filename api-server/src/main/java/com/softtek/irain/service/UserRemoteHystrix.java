package com.softtek.irain.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @auther kaishen
 * @create 2019-07-21 4:40 PM
 */
@Component
public class UserRemoteHystrix implements UserRemote {
    @Override
    public String findUsers(String name) {
        return "Hello " + name + ", server is down";
    }
}
