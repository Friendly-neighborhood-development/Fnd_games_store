package com.fnd.games_store.cart.repository;

import com.fnd.games_store.cart.entity.Cart;
import com.fnd.games_store.cart.entity.Game;

import java.util.Set;

public interface RedisRepository {


    public void createCartEntry(Cart cart);

    public Set<Game> getCartByUserId(String cartId, String userId);

    public void deleteCartById(String userId, String gameId);

    public void updateCart(Cart cart);

}
