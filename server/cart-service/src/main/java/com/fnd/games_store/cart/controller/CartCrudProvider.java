package com.fnd.games_store.cart.controller;

import org.springframework.http.ResponseEntity;

public interface CartCrudProvider {


    public ResponseEntity<String> addItemToCart();



}
