package com.order.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.order.board.entity.UserEntity;
import com.order.board.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;
	
	public UserEntity getById(Long id) {
		return this.userRepository.findById(id).get();
	}
	
	public List<UserEntity> getAll() {
		return this.userRepository.findAll();
	}

}
