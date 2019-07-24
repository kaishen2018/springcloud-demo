package com.softtek.irain.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description
 * @auther kaishen
 * @create 2019-07-21 4:40 PM
 */
@Service
@FeignClient(value = "user-service", fallback = UserRemoteHystrix.class)
public interface UserRemote {
    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/users")
    String findUsers(@RequestParam(value = "name") String name);
}
