package com.fnd.games_store.cart.repository;

import com.fnd.games_store.cart.entity.Cart;

import java.util.Map;

public interface RedisRepository {


    public void addCart(Cart cart);

    public Cart getCartById(String cartId);

    public void deleteCartById(String cartId);

    public void updateItem(Cart cart);

}
