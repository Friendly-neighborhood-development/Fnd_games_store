package com.fnd.games_store.cart.service.implementation;

import com.fnd.games_store.cart.dto.CartRequestDTO;
import com.fnd.games_store.cart.dto.CartResponseDTO;
import com.fnd.games_store.cart.dto.GameResponseDTO;
import com.fnd.games_store.cart.repository.CartRepository;
import com.fnd.games_store.cart.service.CartCrudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@Slf4j
public class CartService implements CartCrudService {

    private CartRepository redisRepository;

//    @Autowired
//    public CartService(RedisRepository redisRepository) {
//        this.redisRepository = redisRepository;
//    }

    @Override
    public Optional<GameResponseDTO> getCartContent(String userId) {
        return Optional.empty();
    }

    @Override
    public CartResponseDTO deleteGameEntry(String userId, String gameId) {
        return new CartResponseDTO();
    }

    @Override
    public CartResponseDTO updateCart(CartRequestDTO cart) {
        return new CartResponseDTO();
    }
}
