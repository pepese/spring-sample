package com.pepese.sample.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pepese.sample.model.User;
import com.pepese.sample.service.security.UserDetails;

@Controller
public class HelloController {

	@ModelAttribute
	private User setUpUserForm() {
		return new User();
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(@AuthenticationPrincipal UserDetails userDetails, Model model) {
		model.addAttribute("user", userDetails.getUser());
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
}
