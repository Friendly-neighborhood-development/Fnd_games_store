package com.fnd.games_store.cart.repository;

import com.fnd.games_store.cart.entity.Cart;

public interface RedisRepository {


    public void persistCart(Cart cart);

    public Cart getCartBySessionId(String sessionId);

    public void deleteCartById(String userId);

    public void updateCart(Cart cart);

}
