package com.fnd.games_store.cart.service.implementation;

import com.fnd.games_store.cart.dto.CartRequestDTO;
import com.fnd.games_store.cart.dto.CartResponseDTO;
import com.fnd.games_store.cart.dto.GameResponseDTO;
import com.fnd.games_store.cart.entity.Cart;
import com.fnd.games_store.cart.repository.CartRepository;
import com.fnd.games_store.cart.service.CartCrudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CartService implements CartCrudService {

    private CartRepository repository;
    @Autowired
    public CartService(CartRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<GameResponseDTO> getCartContent(String userId) {

        Cart cart = repository.findById(userId).orElse(new Cart());

        return cart.getGameData().stream().map(GameResponseDTO::new).collect(Collectors.toList());
    }


    @Override
    public CartResponseDTO updateCart(CartRequestDTO incomingCartData) {

        Cart updatingCart = new Cart();
        updatingCart.setUserId(incomingCartData.getUserId());
        updatingCart.setGameData(incomingCartData.getGameData().stream().distinct().collect(Collectors.toList()));


        return new CartResponseDTO(repository.findById(updateCart(updatingCart).getUserId()).orElse(new Cart()));
    }


    private Cart updateCart(Cart updatingCart){
        return repository.save(updatingCart);
    }


}
