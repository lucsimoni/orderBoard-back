package com.order.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.order.board.entity.UserEntity;
import com.order.board.repository.UserRepository;
import com.order.dto.UpdateUserDto;

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
	
//	@Override pour impl
	public UserEntity updateUser(UpdateUserDto user) {
		final UserEntity userToUpdate = this.userRepository.findById(user.getId()).get();
		if(userToUpdate == null) {
			return null;
		} else {
			userToUpdate.setFirstname(user.getFirstName());
			userToUpdate.setName(user.getName());
			return this.userRepository.save(userToUpdate);
		}
	}

}
