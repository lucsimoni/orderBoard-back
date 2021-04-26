package com.order.board.service.implementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.order.board.BoardException;
import com.order.board.entity.UserEntity;
import com.order.board.repository.UserRepository;
import com.order.board.service.AuthenticationService;
import com.order.dto.LoginDto;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	private final BoardException boardException = new BoardException();
	
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;
	
	@Override
	public UserEntity login(LoginDto loginCredentials) throws BoardException {
//		if(loginCredentials.getLogin().equals("lsimoni")) {
//			throw new BoardException(boardException.getErrorTest());
//		}
		return userRepository.findOneByLoginAndPassword(loginCredentials.getLogin(), loginCredentials.getPassword());
	}
}
