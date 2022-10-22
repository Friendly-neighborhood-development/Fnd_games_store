package com.fnd.games_store.cart.repository.implementation;

import com.fnd.games_store.cart.entity.Cart;
import com.fnd.games_store.cart.entity.Game;
import com.fnd.games_store.cart.repository.RedisRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@NoArgsConstructor
@Repository
public class CartRepository implements RedisRepository {

    @Autowired
    private RedisTemplate<String, Game> redisTemplate;

    private HashOperations<String,String,Game> hashOperations;

    private final String cartHashKey = "";

    @Autowired
    public CartRepository(RedisTemplate<String, Game> redisTemplate) {
        this.redisTemplate = redisTemplate;
        hashOperations = redisTemplate.opsForHash();
    }


    @Override
    public Cart updateCart(Cart cart) {
        hashOperations.put(cart.getUserId(),cart.getGameId(),cart.getGameData());
        return cart;
    }

    @Override
    public List<Game> getCartContent(String userId) {
        return hashOperations.values(userId);
    }

    @Override
    public void deleteGameEntry(String userId, String gameId) {
        hashOperations.delete(userId, gameId);
    }


}
