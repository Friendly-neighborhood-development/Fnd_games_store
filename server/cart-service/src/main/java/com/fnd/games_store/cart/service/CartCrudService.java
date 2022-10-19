package com.fnd.games_store.cart.service;

import com.fnd.games_store.cart.entity.Cart;

import java.util.List;
import java.util.Optional;

public interface CartCrudService {

    public void updateCart(Cart cart);
    public Optional<Cart> getCartContent(String userId);
    public void deleteGameEntry(String userId, String gameId);

}
