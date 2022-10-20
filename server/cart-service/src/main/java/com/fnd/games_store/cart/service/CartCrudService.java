package com.fnd.games_store.cart.service;

import com.fnd.games_store.cart.dto.CartRequestDTO;
import com.fnd.games_store.cart.dto.CartResponseDTO;
import com.fnd.games_store.cart.dto.GameResponseDTO;
import com.fnd.games_store.cart.entity.Cart;
import com.fnd.games_store.cart.entity.Game;

import java.util.List;
import java.util.Optional;

public interface CartCrudService {

    public CartResponseDTO updateCart(CartRequestDTO cart);
    public Optional<GameResponseDTO> getCartContent(String userId);
    public CartResponseDTO deleteGameEntry(String userId, String gameId);

}
