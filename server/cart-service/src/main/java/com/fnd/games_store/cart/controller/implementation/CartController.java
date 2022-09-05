package com.fnd.games_store.cart.controller.implementation;

import com.fnd.games_store.cart.controller.CartCrudProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public class CartController implements CartCrudProvider {


    @Override
    @GetMapping("/addItem")
    public ResponseEntity<String> addItemToCart() {
        return ResponseEntity.ok("item added!");
    }
}
