package com.order.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.order.board.entity.UserEntity;


@Repository("userRepository")
public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
