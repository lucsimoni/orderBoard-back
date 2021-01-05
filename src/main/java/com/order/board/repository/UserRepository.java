package com.order.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.order.board.entity.UserEntity;


@Repository("userRepository")
public interface UserRepository extends JpaRepository<UserEntity, String> {

	/*
	 @Query(value = "SELECT toto FROM UserEntity ue WHERE ue.id IN ?1 AND status = ?2")
	 List<UserEntity> findByListIdAndStatus(List<UUID> listeId, String status);
	 
	 @Query(value = "SELECT toto FROM UserEntity ue WHERE ue.id = (SELECT toto ...))
	 List<UserEntity> findByListIdAndStatus(List<UUID> listeId, String status);
	 
	 
	 */
	
	UserEntity findOneByLoginAndPassword(String login, String password);
	
}
