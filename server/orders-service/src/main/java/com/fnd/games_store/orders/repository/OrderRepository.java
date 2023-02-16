package com.fnd.games_store.orders.repository;

import com.fnd.games_store.orders.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
}
