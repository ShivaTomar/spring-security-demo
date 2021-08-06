package com.spring.securitydemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

	@GetMapping
	public String index() {
		return "Welcome to the Spring Security demo application";
	}

}
