package com.spring.securitydemo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApplicationUser {
	private String name;
	private String password;
	private String role;
}
