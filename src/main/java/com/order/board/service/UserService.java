package com.order.board.service;

import java.util.List;

import com.order.board.entity.UserEntity;
import com.order.dto.UpdateUserDto;

public interface UserService {

	/**
	 * Récupère un utilisateur à partir de son id
	 * @param id d'un utilisateur
	 * @return utilisateur
	 */
	public UserEntity getById(String id);
	
	/**
	 * Récupère la liste de tous les utilisateurs
	 * @return Liste d'utilisateurs
	 */
	public List<UserEntity> getAll();
	
	/**
	 * Mis à jour d'informations utilisateur
	 * @param user - id name firstname
	 * @return l'utilisateur mis à jour
	 */
	public UserEntity updateUser(UpdateUserDto user);
	
}
