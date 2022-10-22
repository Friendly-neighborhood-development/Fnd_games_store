package com.fnd.games_store.cart.repository;

import com.fnd.games_store.cart.entity.Cart;
import com.fnd.games_store.cart.entity.Game;

import java.util.List;

public interface RedisRepository {


    public Cart updateCart(Cart cart);

    public List<Game> getCartContent(String userId);

    public void deleteGameEntry(String userId, String gameId);



}
