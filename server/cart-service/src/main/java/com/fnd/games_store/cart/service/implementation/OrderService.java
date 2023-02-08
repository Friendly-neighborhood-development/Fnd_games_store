package com.fnd.games_store.cart.service.implementation;

import com.fnd.games_store.cart.dto.CartResponseDTO;
import com.fnd.games_store.cart.entity.Cart;
import com.fnd.games_store.cart.exception.CartNotFoundException;
import com.fnd.games_store.cart.repository.CartRepository;
import com.fnd.games_store.cart.service.OrderProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService implements OrderProcessingService {


    private final CartRepository repository;

    @Autowired
    public OrderService(CartRepository repository) {
        this.repository = repository;
    }


    @Override
    public CartResponseDTO purchaseGames(String userId) {




        return new CartResponseDTO(findGameById(userId).get());
    }


    private Optional<Cart> findGameById(String userId) {

        Optional<Cart> foundCartData = repository.findById(userId);

        if (foundCartData.isPresent()){
            repository.deleteById(userId);
        } else throw new CartNotFoundException("Cart not found");

        return foundCartData;
    }


    private void eraseCart(String userId) {
        repository.deleteById(userId);
    }

    private void confirmPurchase(String userId){

    }


}
