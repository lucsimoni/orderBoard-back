package com.order.board.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.board.entity.UserEntity;
import com.order.board.service.AuthenticationService;
import com.order.dto.LoginDto;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api/authentication")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService authenticationService;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserEntity> login(@RequestBody @Valid @NotEmpty LoginDto loginCredentials) {
		authenticationService.login(loginCredentials);
		//		return new ResponseEntity<>(authenticationService.updateUser(user), HttpStatus.OK);
		return null;
	}
	
	@GetMapping("/test")
	public ResponseEntity<String> test() {
		logger.info("Réponse du controleur AUTHENTICATION OK.");
		return new ResponseEntity<String>("Réponse du serveur " + HttpStatus.OK.name(), HttpStatus.OK);
	}

}
