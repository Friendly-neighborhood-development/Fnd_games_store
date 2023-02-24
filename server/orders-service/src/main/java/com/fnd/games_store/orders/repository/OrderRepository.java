package com.fnd.games_store.orders.repository;

import com.fnd.games_store.orders.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, String> {

    Optional<Order> findOrderByUserId(String userId);


}
