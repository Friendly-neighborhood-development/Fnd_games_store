package com.fnd.games_store.cart.service;

import com.fnd.games_store.cart.entity.Cart;

import java.util.Optional;

public interface CartCrudService {


    public void persistCart(Cart cart);

    public Optional<Cart> getCartById(String cartId);

    public void deleteCartById(String cartId);

    public void updateCart(Cart cart);



}
