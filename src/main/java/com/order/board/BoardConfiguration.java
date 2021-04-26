package com.order.board;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class BoardConfiguration extends ResourceServerConfigurerAdapter {

//	@Override
//	//TODO just login
//	public void configure(final HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//			.antMatchers("**")
//			.permitAll()
//			.anyRequest()
//			.authenticated();
//	}
	
	@Override
	public void configure(final HttpSecurity http) throws Exception {
		http.httpBasic().and().authorizeRequests()
		.antMatchers("/api/authentication/login", "/v2/api-docs", "/configuration/**", "/swagger-resources/**",  "/swagger-ui.html", "/webjars/**", "/api-docs/**").permitAll()
		.anyRequest().authenticated();
	}
	
	
}
