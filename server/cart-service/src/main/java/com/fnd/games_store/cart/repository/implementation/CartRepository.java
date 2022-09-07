package com.fnd.games_store.cart.repository.implementation;

import com.fnd.games_store.cart.entity.Cart;
import com.fnd.games_store.cart.repository.RedisRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

@NoArgsConstructor
public class CartRepository implements RedisRepository {

    private String key;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private HashOperations hashOperations;


    @Autowired
    public CartRepository(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
        hashOperations = redisTemplate.opsForHash();
    }


    @Override
    public void addCart(Cart cart) {
        hashOperations.put(key,cart.getSessionId(),cart);
    }

    @Override
    public Cart getCartById(String cartId) {
        return (Cart) hashOperations.get(key,cartId);
    }

    @Override
    public void deleteCartById(String cartId) {
        hashOperations.delete(key, cartId);
    }

    @Override
    public void updateItem(Cart cart) {
        addCart(cart);
    }
}
