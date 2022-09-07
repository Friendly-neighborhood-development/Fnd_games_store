package com.fnd.games_store.cart.service.implementation;

import com.fnd.games_store.cart.entity.Cart;
import com.fnd.games_store.cart.repository.RedisRepository;
import com.fnd.games_store.cart.service.CartCrudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@Slf4j
public class CartService implements CartCrudService {

    private RedisRepository redisRepository;

    @Override
    public void persistCart(Cart cart) {

    }

    @Override
    public Optional<Cart> getCartById(String cartId) {
        return Optional.empty();
    }

    @Override
    public void deleteCartById(String cartId) {

    }

    @Override
    public void updateCart(Cart cart) {

    }
}
