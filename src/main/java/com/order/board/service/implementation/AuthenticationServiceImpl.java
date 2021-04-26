package com.order.board.service.implementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
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
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;
	
	@Override
	public UserEntity login(LoginDto loginCredentials) throws BoardException {
//		if(loginCredentials.getLogin().equals("lsimoni")) {
//			throw new BoardException(boardException.getErrorTest());
//		}
		this.encodePassword(loginCredentials.getPassword());
		return userRepository.findOneByLoginAndPassword(loginCredentials.getLogin(), loginCredentials.getPassword());
	}
	
//	user.setPassword(passwordEncoder.encode(accountDto.getPassword()));
	
	//Spring security password Encoder
	private void encodePassword(String password) {
		final String pwd = passwordEncoder.encode(password);
		logger.error("LSI Encode : {}", pwd);
	}
	
	
}
