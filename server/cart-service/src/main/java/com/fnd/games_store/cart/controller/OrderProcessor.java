package com.fnd.games_store.cart.controller;

import com.fnd.games_store.cart.dto.OrderResponseDTO;
import org.springframework.http.ResponseEntity;

public interface OrderProcessor {

    public ResponseEntity<OrderResponseDTO> processOrder(String userId);



}
