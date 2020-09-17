package com.order.board.service.implementation;

import java.util.List;
import java.util.Random;

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
	
	private static final short PASSWORD_LENGTH = 8;
	
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
			//TODO throw exception
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
		user.setFirstname(userData.getFirstName().toLowerCase());
		user.setName(userData.getName().toLowerCase());
		
		// TODO check role valide
		user.setRole(userData.getRole().toLowerCase());
		
		user.setLastConnection(null);
		
		final String login = this.generateLogin(userData.getFirstName().toLowerCase(), userData.getName().toLowerCase());
		if(isLoginUnique(login)) {
			user.setLogin(login);	
		} else {
			//TODO throw exception
			return null;
		}
		
		user.setPassword(this.generatePassword());

				
		//final UUID test = UUID.randomUUID();
		//logger.info("UUID genere. {}", test);
		return this.userRepository.save(user);
	}
	
	@Override
	public void deleteUser(String id) {
		this.userRepository.deleteById(id);
	}

	@Override
	public void deleteAll() {
		this.userRepository.deleteAll();
	}
	
	/**
	 * Génère le login utilisateur à partir de la première lettre du prénom et du nom
	 * Jean DUPONT - jdupont
	 * @param firstName String
	 * @param name String
	 * @return login String
	 */
	private String generateLogin(String firstName, String name) {
		final String login = (firstName.substring(0, 1)).concat(name);
		return login;
	}
	
	/**
	 * Vérifie l'unicité d'un login
	 * @param login String
	 * @return Boolean - true si login non existant, false sinon
	 */
	private Boolean isLoginUnique(String login) {
		final List<UserEntity> allUsers = this.getAll();
		for (UserEntity user : allUsers) {
			if(user.getLogin().equals(login)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Génération d'un mot de passe aléatoire sur 8 caractères
	 * @return String Password
	 */
	private String generatePassword() {
	    int leftLimit = 97; // Lettre 'a'
	    int rightLimit = 122; // Lettre 'z'
	    Random random = new Random();
	    
	    StringBuilder buffer = new StringBuilder(PASSWORD_LENGTH);
	    for (int i = 0; i < PASSWORD_LENGTH; i++) {
	        int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
	        buffer.append((char) randomLimitedInt);
	    }
	    String generatedString = buffer.toString();
	    //TODO hachage
	    return generatedString;
	}
	
	

}
