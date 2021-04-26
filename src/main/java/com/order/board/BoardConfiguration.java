package com.order.board;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class BoardConfiguration extends WebSecurityConfigurerAdapter  {

	@Bean
	public PasswordEncoder encoder() {
	    return new BCryptPasswordEncoder();
	}
	
	@Override
	public void configure(final HttpSecurity http) throws Exception {
		//TODO just login
		http.authorizeRequests()
			.antMatchers("**")
			.permitAll()
			.anyRequest()
			.authenticated();
	}
	
}
