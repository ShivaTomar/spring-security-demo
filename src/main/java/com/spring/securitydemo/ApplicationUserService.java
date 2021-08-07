package com.spring.securitydemo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@Component
public class ApplicationUserService {
	private List<ApplicationUser> users;

	ApplicationUserService() {
		users = new ArrayList<>();
		users.add(new ApplicationUser("erin", "123", "ROLE_ADMIN"));
		users.add(new ApplicationUser("mike", "234", "ROLE_STUDENT"));
	}

	public Optional<ApplicationUser> getUser(String userName) {
		return users.stream()
			.filter(user -> user.getName().equals(userName))
			.findFirst();
	}
}
