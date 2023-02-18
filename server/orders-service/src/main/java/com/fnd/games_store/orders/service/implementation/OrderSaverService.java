package com.fnd.games_store.orders.service.implementation;

import com.fnd.games_store.orders.dto.OrderRequestDTO;
import com.fnd.games_store.orders.entity.Game;
import com.fnd.games_store.orders.entity.Order;
import com.fnd.games_store.orders.repository.OrderRepository;
import com.fnd.games_store.orders.service.OrderSaver;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

public class OrderSaverService implements OrderSaver {



    private final OrderRepository orderRepository;

    @Autowired
    public OrderSaverService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void saveOrder(OrderRequestDTO incomingOrderData) {

        Order savableOrderData = new Order();

        savableOrderData.setIsOrderProcessed(true);
        savableOrderData.setUserId(incomingOrderData.getUserId());
        savableOrderData.setGames(incomingOrderData.getGameData().stream().map((Game::new)).collect(Collectors.toList()));

        orderRepository.save(savableOrderData);

    }



}
