package com.fnd.games_store.orders.service;

import com.fnd.games_store.orders.dto.OrderResponseDTO;

public interface OrderFetcher {

    OrderResponseDTO fetchOrderData(String userId);

}
