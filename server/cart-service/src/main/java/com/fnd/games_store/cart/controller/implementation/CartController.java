package com.fnd.games_store.cart.controller.implementation;

import com.fnd.games_store.cart.controller.ItemCreator;
import org.springframework.http.ResponseEntity;

public class CartController implements ItemCreator {



    @Override
    public ResponseEntity<String> addItemToCart() {
        return ResponseEntity.ok("item added!");
    }
}
