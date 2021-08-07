package com.spring.securitydemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class AuthenticationProviderUserPassword implements AuthenticationProvider {

	@Autowired
	private ApplicationUserService userService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		var identity = authentication.getName().toLowerCase();
		var secret = authentication.getCredentials().toString();

		var user = this.userService.getUser(identity);

		if (user.isEmpty()) {
			throw new BadCredentialsException(String.format("User: %s not found.", identity));
		}

		if (!user.get().getPassword().equals(secret)) {
			throw new BadCredentialsException("Incorrect Password");
		}

		var authorities = Arrays.asList(new SimpleGrantedAuthority(user.get().getRole()));
		return new UsernamePasswordAuthenticationToken(identity, secret, authorities);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
