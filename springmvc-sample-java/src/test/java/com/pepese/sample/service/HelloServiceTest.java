package com.pepese.sample.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.pepese.sample.config.AppConfig;
import com.pepese.sample.config.WebMvcConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class, WebMvcConfig.class})
@WebAppConfiguration
public class HelloServiceTest {

    @Autowired
    HelloService helloService;

    @Test
    public void testSayHello() throws Exception {
        assertEquals("Hello, PePeSe !", helloService.sayHello("PePeSe"));
    }

}
