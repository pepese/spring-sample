package com.pepese.sample.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    private String greeting = "Hello";

    public String sayHello(String name) {
        return this.greeting + ", " + name + " !";
    }
}
