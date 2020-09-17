package com.order.board.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.board.entity.UserEntity;
import com.order.board.service.UserService;
import com.order.dto.CreateUserDto;
import com.order.dto.UpdateUserDto;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api/user")
public class UserController {

	@Autowired
	private UserService userService;

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	// throws exception - gcexception - test - authentication
	// response entity
	@GetMapping("/{id}")
	public ResponseEntity<UserEntity> getUser(@PathVariable @NotEmpty String id) {
		if (id != null) {
			return new ResponseEntity<>(userService.getById(id), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<UserEntity>> getAll() {
		return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
	}

	@PostMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserEntity> updateUser(@RequestBody @Valid @NotEmpty UpdateUserDto user) {
		return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
	}

	@PutMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserEntity> createUser(@RequestBody @Valid @NotEmpty CreateUserDto user) {
		return new ResponseEntity<>(userService.createUser(user), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteUser(@PathVariable @NotEmpty String id) {
		userService.deleteUser(id);
	}
	
	@DeleteMapping("/deleteAll")
	public void deleteAll() {
		userService.deleteAll();
	}
	
	@GetMapping("/test")
	public ResponseEntity<String> test() {
		logger.info("Réponse du controleur USER OK.");
		return new ResponseEntity<String>("Réponse du serveur " + HttpStatus.OK.name(), HttpStatus.OK);
	}

}
