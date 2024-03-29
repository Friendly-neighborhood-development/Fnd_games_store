package com.fnd.games_store.orders.service.implementation;

import com.fnd.games_store.orders.dto.OrderResponseDTO;
import com.fnd.games_store.orders.exception.OrderNotFoundException;
import com.fnd.games_store.orders.repository.OrderRepository;
import com.fnd.games_store.orders.service.OrderFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class OrderFetcherService implements OrderFetcher {


    private final OrderRepository orderRepository;

    @Autowired
    public OrderFetcherService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    @Transactional(label = "fetch_orders",
            propagation = Propagation.REQUIRED,
            isolation = Isolation.REPEATABLE_READ,
            timeout = 5,
            readOnly = true,
            rollbackFor = {OrderNotFoundException.class})
    @Override
    public List<OrderResponseDTO> fetchOrderData(String userId) {
        return orderRepository.findOrdersByUserId(userId).orElseThrow(()-> new OrderNotFoundException("Oder data is missing")).stream().map(OrderResponseDTO::new).collect(Collectors.toList());
    }
}
