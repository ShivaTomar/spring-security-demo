package com.spring.securitydemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class RootController {

	@GetMapping
	public String index(Authentication authentication) {
		log.info("RootController.index() is called for user: {}", authentication.getName());
		return String.format("Hey %s welcome to the Spring Security demo application.", authentication.getName());
	}

}
