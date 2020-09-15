package com.order.board.service.implementation;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.order.board.entity.UserEntity;
import com.order.board.repository.UserRepository;
import com.order.board.service.UserService;
import com.order.dto.CreateUserDto;
import com.order.dto.UpdateUserDto;

@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;
	
	@Override
	public UserEntity getById(String id) {
		return this.userRepository.findById(id).get();
	}
	
	@Override
	public List<UserEntity> getAll() {
		return this.userRepository.findAll();
	}
	
	@Override
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
	
	@Override
	public UserEntity createUser(CreateUserDto userData) {
		final UserEntity user = new UserEntity();
		user.setId(UUID.randomUUID().toString());
		user.setFirstname(userData.getFirstName());
		user.setName(userData.getName());
		user.setRole(userData.getRole());
		user.setLastConnection(null);

		// TODO check le role
		// TODO genere un login
		// TODO genere password
		// TODO hash password
		
		
		final UUID test = UUID.randomUUID();
		logger.info("UUID genere. {}", test);
		return null;
	}

}
