package com.fnd.games_store.orders.service;

import com.fnd.games_store.orders.dto.OrderResponseDTO;

import java.util.List;

public interface OrderFetcher {

   List<OrderResponseDTO> fetchOrderData(String userId);

}
