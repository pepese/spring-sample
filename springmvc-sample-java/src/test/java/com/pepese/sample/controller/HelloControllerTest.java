package com.pepese.sample.controller;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.pepese.sample.config.AppConfig;
import com.pepese.sample.config.WebMvcConfig;
import com.pepese.sample.service.HelloService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class, WebMvcConfig.class })
@WebAppConfiguration
public class HelloControllerTest {
	
	private MockMvc mvc;
	
	@Rule
    public final MockitoRule rule = MockitoJUnit.rule();
	
	@InjectMocks
	private HelloController helloController;

	@Mock
	private HelloService helloService;

	@Before
	public void setup() {
		mvc = MockMvcBuilders.standaloneSetup(this.helloController).build();
	}

	@Test
	public void testOK() throws Exception {
		when(this.helloService.sayHello("PePeSe")).thenReturn("Hello, PePeSe !");
		mvc.perform(get("/")).andExpect(status().isOk()).andExpect(content().string(containsString("Hello, PePeSe !")));
	}
}
