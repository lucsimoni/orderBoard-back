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
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.order.board.BoardException;
import com.order.board.entity.UserEntity;
import com.order.board.service.AuthenticationService;
import com.order.dto.LoginDto;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/authentication")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService authenticationService;
	
	private final BoardException boardException = new BoardException();
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	
	@ApiOperation("Authentification")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Utilisateur authentifié"),
			@ApiResponse(code = 403, message = "Utilisateur non activé"),
			@ApiResponse(code = 401, message = "Utilisateur non authentifié")
	})
	@PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserEntity> login(@RequestBody @Valid @NotEmpty LoginDto loginCredentials) throws BoardException {
		final UserEntity user = authenticationService.login(loginCredentials);
		if(user != null) {
			if(user.isActive()) {
				return new ResponseEntity<UserEntity>(user, HttpStatus.OK);	
			} else {
				throw new BoardException(boardException.getErrorUserInactive());
			}
		} else {
			throw new BoardException(boardException.getErrorUserNotFound());
		}
	}
	
	//TODO syntaxe try catch 2 syntaxe dans spring bfp
	//TODO response entity et trhrow error
	//TODO hash et unhash
	//TODO spring security
	//TODO token
	
	@GetMapping("/test")
	public ResponseEntity<String> test() {
		logger.info("Réponse du controleur AUTHENTICATION OK.");
		return new ResponseEntity<String>("Réponse du serveur " + HttpStatus.OK.name(), HttpStatus.OK);
	}
	
	@GetMapping("/test2")
	public ResponseEntity<String> test2() {
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
