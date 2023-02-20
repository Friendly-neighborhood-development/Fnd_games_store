package com.fnd.games_store.orders.service.implementation;

import com.fnd.games_store.orders.dto.OrderResponseDTO;
import com.fnd.games_store.orders.repository.OrderRepository;
import com.fnd.games_store.orders.service.OrderFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderFetcherService implements OrderFetcher {


    private final OrderRepository repository;

    @Autowired
    public OrderFetcherService(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public OrderResponseDTO fetchOrderData(String userId) {
        return new OrderResponseDTO(repository.findOrderByUserId(userId).get());
    }
}
