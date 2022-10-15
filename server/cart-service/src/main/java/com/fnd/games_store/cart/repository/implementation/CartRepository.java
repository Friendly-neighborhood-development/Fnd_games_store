package com.fnd.games_store.cart.repository.implementation;

import com.fnd.games_store.cart.entity.Cart;
import com.fnd.games_store.cart.repository.RedisRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@NoArgsConstructor
@Repository
public class CartRepository implements RedisRepository {

    private String key;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private HashOperations<String,String,Object> hashOperations;


    @Autowired
    public CartRepository(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
        hashOperations = redisTemplate.opsForHash();
    }


    @Override
    public void persistCart(Cart cart) {
        hashOperations.putIfAbsent(cart.getUserId(),cart.getGameId(),cart.getShoppingSet());
    }

    @Override
    public Cart getCartBySessionId(String sessionId) {
        return (Cart) hashOperations.get(key, sessionId);
    }

    @Override
    public void deleteCartById(String userId, String gameId) {
        hashOperations.delete(userId, gameId);
    }

    @Override
    public void updateCart(Cart cart) {
        persistCart(cart);
    }
}
