package com.fnd.games_store.cart.repository;

import com.fnd.games_store.cart.entity.Cart;
import com.fnd.games_store.cart.entity.Game;

import java.util.List;

public interface RedisRepository {


    public void createCartEntry(Cart cart);

    public List<List<Game>> getCartContent(String userId);

    public void deleteCartById(String userId);

    public void updateCart(Cart cart);

}
