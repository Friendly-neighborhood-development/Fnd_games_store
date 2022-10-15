package com.fnd.games_store.cart.repository;

import com.fnd.games_store.cart.entity.Cart;

public interface RedisRepository {


    public void createCartEntry(Cart cart);

    public Cart getCartByUserId(String cartId, String userId);

    public void deleteCartById(String userId, String gameId);

    public void updateCart(Cart cart);

}
