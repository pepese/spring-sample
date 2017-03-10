package com.pepese.sample.controller;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/resources/META-INF/spring/spring-mvc.xml",
		"file:src/main/resources/META-INF/spring/applicationContext.xml",
		"file:src/main/resources/META-INF/spring/spring-security.xml",
		"file:src/main/resources/META-INF/spring/spring-session.xml" })
@WebAppConfiguration
public class HelloControllerTest {

	private MockMvc mvc;

	@Autowired
	private WebApplicationContext context;

	@Rule
	public final MockitoRule rule = MockitoJUnit.rule();

	@InjectMocks
	private HelloController helloController;

	@Before
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
	}

	@Test
	public void testOK() throws Exception {
		mvc.perform(get("/")).andExpect(status().is3xxRedirection());
	}
}
