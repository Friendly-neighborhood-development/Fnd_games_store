package com.fnd.games_store.orders.controller;

import com.fnd.games_store.orders.dto.OrderResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderController {


    ResponseEntity<List<OrderResponseDTO>> getOrderData(String userId);

}
