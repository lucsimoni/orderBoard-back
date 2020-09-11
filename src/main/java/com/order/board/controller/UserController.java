package com.order.board.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.board.entity.UserEntity;
import com.order.board.service.UserService;

@RestController
@RequestMapping(value="/api/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@GetMapping("/get/{id}")
	public UserEntity getUser(@PathVariable Long id) {
		if(id != null) {
			return userService.getById(id);
		}
		return null;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getAll")
	public List<UserEntity> getAll() {
		return userService.getAll();
	}
	
	@GetMapping("/test")
	public ResponseEntity<String> test() {
		logger.info("Démarrage du service USER OK.");
		return new ResponseEntity<String>("Réponse du serveur "+HttpStatus.OK.name(), HttpStatus.OK);
	}
}
