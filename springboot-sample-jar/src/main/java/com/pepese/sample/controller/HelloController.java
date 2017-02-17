package com.pepese.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pepese.sample.service.HelloService;

@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @RequestMapping("/")
    public String index() {
        return helloService.sayHello("PePeSe");
    }

}
