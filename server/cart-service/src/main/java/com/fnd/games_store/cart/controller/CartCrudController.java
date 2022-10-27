package com.fnd.games_store.cart.controller;

import com.fnd.games_store.cart.dto.CartRequestDTO;
import com.fnd.games_store.cart.dto.CartResponseDTO;
import com.fnd.games_store.cart.dto.GameRequestDTO;
import com.fnd.games_store.cart.dto.GameResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.Set;

public interface CartCrudController {


    public ResponseEntity<CartResponseDTO> updateCart(CartRequestDTO cartRequestDTO);

    public ResponseEntity<Set<GameResponseDTO>> getCartContent(GameRequestDTO gameRequestDTO);

}
