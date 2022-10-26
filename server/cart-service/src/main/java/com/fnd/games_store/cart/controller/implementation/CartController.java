package com.fnd.games_store.cart.controller.implementation;

import com.fnd.games_store.cart.controller.CartCrudController;
import com.fnd.games_store.cart.dto.CartRequestDTO;
import com.fnd.games_store.cart.dto.CartResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController implements CartCrudController {


    @Override
    @GetMapping("/v1/update")
    public ResponseEntity<CartResponseDTO> updateCart(CartRequestDTO cartRequestDTO) {
        return ResponseEntity.ok(new CartResponseDTO());
    }
}
