package com.pepese.sample.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/resources/META-INF/spring/spring-mvc.xml",
		"file:src/main/resources/META-INF/spring/applicationContext.xml" })
@WebAppConfiguration
public class HelloServiceTest {

	@Autowired
	HelloService helloService;

	@Test
	public void testSayHello() throws Exception {
		assertEquals("Hello, PePeSe !", helloService.sayHello("PePeSe"));
	}

}
