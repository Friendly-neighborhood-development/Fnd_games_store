package com.fnd.games_store.cart.service;

import com.fnd.games_store.cart.dto.CartRequestDTO;
import com.fnd.games_store.cart.dto.CartResponseDTO;
import com.fnd.games_store.cart.dto.GameResponseDTO;

import java.util.List;

public interface CartCrudService {

    public CartResponseDTO updateCart(CartRequestDTO cart);
    public List<GameResponseDTO> getCartContent(String userId);

}
