package com.softtek.irain.controller;

import com.softtek.irain.domain.Greeting;
import com.softtek.irain.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/v1/greeting")
public class GreetingController {

    private static final String GREETING = "Hello, %s!";
    private static final String GOODBYE = "Byebye, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    GreetingService service;

    @RequestMapping("/welcome")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(service.welcome(name)));
    }

//    @RequestMapping(value = "/goodbye", method = RequestMethod.POST)
    @PostMapping("/goodbye")
    public Greeting bye(@RequestBody Greeting greeting) {
        return new Greeting(counter.incrementAndGet(),
                String.format(service.goodBye(greeting.getContent())));
    }
}
