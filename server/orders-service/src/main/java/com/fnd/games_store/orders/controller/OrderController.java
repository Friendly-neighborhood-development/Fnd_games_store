package com.fnd.games_store.orders.controller;

import com.fnd.games_store.orders.dto.OrderResponseDTO;
import org.springframework.http.ResponseEntity;

public interface OrderController {


    ResponseEntity<OrderResponseDTO> getOrderData(String userId);

}
