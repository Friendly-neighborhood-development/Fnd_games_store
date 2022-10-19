package com.fnd.games_store.cart.repository;

import com.fnd.games_store.cart.entity.Cart;

import java.util.List;

public interface RedisRepository {


    public void updateCart(Cart cart);

    public List<Object> getCartContent(String userId);

    public void deleteGameEntry(String userId, String gameId);



}
