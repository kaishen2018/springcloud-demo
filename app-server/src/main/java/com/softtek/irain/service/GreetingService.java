package com.softtek.irain.service;

import org.springframework.stereotype.Service;

/**
 * Created by kaishen on 06/09/2018.
 */
@Service
public class GreetingService {

    public String welcome(String name) {
        return "Weclome, " + name;
    }


    public String goodBye(String name) {
        return "GoodBye, "+ name;
    }


}
