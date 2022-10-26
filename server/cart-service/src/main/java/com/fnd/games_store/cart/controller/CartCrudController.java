package com.fnd.games_store.cart.controller;

import com.fnd.games_store.cart.dto.CartRequestDTO;
import com.fnd.games_store.cart.dto.CartResponseDTO;
import org.springframework.http.ResponseEntity;

public interface CartCrudController {


    public ResponseEntity<CartResponseDTO> updateCart(CartRequestDTO cartRequestDTO);



}
