package com.pepese.sample.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloServiceTest {

    @Autowired
    HelloService helloService;

    @Test
    public void testSayHello() throws Exception {
        assertEquals("Hello, PePeSe !", helloService.sayHello("PePeSe"));
    }

}
