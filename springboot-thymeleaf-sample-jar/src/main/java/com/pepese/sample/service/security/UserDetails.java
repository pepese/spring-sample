package com.pepese.sample.service.security;

import org.springframework.security.core.authority.AuthorityUtils;

import com.pepese.sample.model.User;

public class UserDetails extends org.springframework.security.core.userdetails.User {

	private static final long serialVersionUID = 1L;

	private final User user;

	public UserDetails(User user) {
		super(user.getName(), user.getPassword(), AuthorityUtils.createAuthorityList("ROLE_USER"));
		this.user = user;
	}

	public User getUser() {
		return user;
	}
}
