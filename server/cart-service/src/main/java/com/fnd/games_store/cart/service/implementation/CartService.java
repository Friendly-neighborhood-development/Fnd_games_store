package com.fnd.games_store.cart.service.implementation;

import com.fnd.games_store.cart.dto.CartRequestDTO;
import com.fnd.games_store.cart.dto.CartResponseDTO;
import com.fnd.games_store.cart.dto.GameResponseDTO;
import com.fnd.games_store.cart.entity.Cart;
import com.fnd.games_store.cart.repository.RedisRepository;
import com.fnd.games_store.cart.service.CartCrudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@Slf4j
public class CartService implements CartCrudService {

    private RedisRepository redisRepository;

    @Autowired
    public CartService(RedisRepository redisRepository) {
        this.redisRepository = redisRepository;
    }

    @Override
    public Optional<GameResponseDTO> getCartContent(String userId) {
        return Optional.empty();
    }

    @Override
    public CartResponseDTO deleteGameEntry(String userId, String gameId) {

    }

    @Override
    public CartResponseDTO updateCart(CartRequestDTO cart) {
        return new CartResponseDTO();
    }
}
