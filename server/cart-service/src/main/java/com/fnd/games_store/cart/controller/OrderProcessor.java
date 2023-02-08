package com.fnd.games_store.cart.controller;

import com.fnd.games_store.cart.dto.CartResponseDTO;
import com.fnd.games_store.cart.dto.OrderResponseDTO;
import org.springframework.http.ResponseEntity;

public interface OrderProcessor {

    public ResponseEntity<CartResponseDTO> processOrder(String userId);



}
