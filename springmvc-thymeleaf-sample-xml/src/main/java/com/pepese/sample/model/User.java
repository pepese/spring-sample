package com.pepese.sample.model;

import lombok.Data;

@Data
public class User implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private String password = "password";
}
