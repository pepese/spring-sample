package com.pepese.sample.model;

import lombok.Data;

@Data
public class User {
	private String name;
	private String password = "password";
}
