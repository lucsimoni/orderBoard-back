package com.order.board.service;

import com.order.board.BoardException;
import com.order.board.entity.UserEntity;
import com.order.dto.LoginDto;

public interface AuthenticationService {

	/**
	 * todo response entity
	 * @param
	 * @return utilisateur authentifié
	 */
	public UserEntity login(LoginDto loginCredentials) throws BoardException;
	
}
