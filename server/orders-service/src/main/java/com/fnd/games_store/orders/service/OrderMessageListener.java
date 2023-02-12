package com.fnd.games_store.orders.service;

import com.fnd.games_store.orders.dto.OrderDTO;

public interface OrderMessageListener {


    void orderMessageListener(OrderDTO order);

}
