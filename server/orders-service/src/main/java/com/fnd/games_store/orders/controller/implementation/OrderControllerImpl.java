package com.fnd.games_store.orders.controller.implementation;

import com.fnd.games_store.orders.controller.OrderController;
import com.fnd.games_store.orders.dto.OrderResponseDTO;
import com.fnd.games_store.orders.service.OrderFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class OrderControllerImpl implements OrderController {

    private final OrderFetcher service;

    @Autowired
    public OrderControllerImpl(OrderFetcher service) {
        this.service = service;
    }


    @Override
    @GetMapping("/v1/purchases/{userId}")
    public ResponseEntity<List<OrderResponseDTO>> getOrderData(@PathVariable String userId) {
        return ResponseEntity.ok(service.fetchOrderData(userId));
    }
}
