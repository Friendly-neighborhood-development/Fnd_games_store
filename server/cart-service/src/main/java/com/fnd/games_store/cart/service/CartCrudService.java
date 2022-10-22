package com.fnd.games_store.cart.service;

import com.fnd.games_store.cart.dto.CartRequestDTO;
import com.fnd.games_store.cart.dto.CartResponseDTO;
import com.fnd.games_store.cart.dto.GameResponseDTO;
import com.fnd.games_store.cart.entity.Cart;
import com.fnd.games_store.cart.entity.Game;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CartCrudService {

    public CartResponseDTO updateCart(CartRequestDTO cart);
    public Set<GameResponseDTO> getCartContent(String userId);

}
