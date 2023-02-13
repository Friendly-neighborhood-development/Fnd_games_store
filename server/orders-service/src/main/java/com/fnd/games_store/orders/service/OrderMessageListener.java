package com.fnd.games_store.orders.service;

import com.fnd.games_store.orders.dto.OrderRequestDTO;

public interface OrderMessageListener {


    void orderMessageListener(OrderRequestDTO order);

}
