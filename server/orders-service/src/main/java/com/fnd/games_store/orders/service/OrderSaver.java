package com.fnd.games_store.orders.service;

import com.fnd.games_store.orders.dto.OrderRequestDTO;

public interface OrderSaver {


    String saveOrder(OrderRequestDTO incomingOrder);

}
