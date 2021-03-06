package com.order.board.service;

import java.util.List;
import com.order.board.entity.UserEntity;
import com.order.dto.CreateUserDto;
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
	
	/**
	 * Création d'un utilisateur
	 * @param user - name firstname password passwordConfirmation login
	 * @return l'utilisateur créé
	 */
	public UserEntity createUser(CreateUserDto user);
	
	/**
	 * Suppression d'un utilisateur
	 * @param id String
	 * @return void
	 */
	public void deleteUser(String id);
	
	/**
	 * Suppression de tous les utilisateurs
	 * @return void
	 */
	public void deleteAll();
	
}
