package com.fnd.games_store.orders.service.implementation;

import com.fnd.games_store.orders.dto.OrderRequestDTO;
import com.fnd.games_store.orders.entity.Game;
import com.fnd.games_store.orders.entity.Order;
import com.fnd.games_store.orders.repository.OrderRepository;
import com.fnd.games_store.orders.service.OrderSaver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class OrderSaverService implements OrderSaver {



    private final OrderRepository orderRepository;

    @Autowired
    public OrderSaverService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public String saveOrder(OrderRequestDTO incomingOrderData) {

        Order savableOrderData = new Order();

        savableOrderData.setIsOrderProcessed(true);
        savableOrderData.setUserId(incomingOrderData.getUserId());
        savableOrderData.setGames(incomingOrderData.getGameData().stream().map((Game::new)).collect(Collectors.toList()));

        log.info("image from dto: " + incomingOrderData.getGameData().get(0).getBase64Image());
        log.info("nullable image: " +savableOrderData.getGames().get(0).getBase64Image());

        return orderRepository.save(savableOrderData).getId();

    }



}
