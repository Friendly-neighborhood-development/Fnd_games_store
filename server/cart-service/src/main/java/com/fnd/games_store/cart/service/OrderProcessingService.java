package com.fnd.games_store.cart.service;

import com.fnd.games_store.cart.dto.CartResponseDTO;

public interface OrderProcessingService {

    CartResponseDTO purchaseGames(String userId);


}
