package com.fnd.games_store.cart.controller.implementation;

import com.fnd.games_store.cart.controller.CartCrudController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController implements CartCrudController {


    @Override
    @GetMapping("/addItem")
    public ResponseEntity<String> addItemToCart() {
        return ResponseEntity.ok("item added!");
    }
}
