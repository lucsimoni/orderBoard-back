package com.order.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.order.board.entity.OrderEntity;

@Repository("orderRepository")
public interface OrderRepository extends JpaRepository<OrderEntity, String> {

}
