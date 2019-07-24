package com.softtek.irain.controller;

import com.softtek.irain.service.UserRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @auther kaishen
 * @create 2019-07-21 4:53 PM
 */
@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    @Autowired
    UserRemote userRemote;

    @RequestMapping("/list/{name}")
    public String index(@PathVariable("name") String name) {
        return userRemote.findUsers(name);
    }

}
