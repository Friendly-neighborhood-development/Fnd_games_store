package com.fnd.games_store.cart.controller.implementation;


import com.fnd.games_store.cart.controller.OrderProcessor;
import com.fnd.games_store.cart.dto.OrderResponseDTO;
import com.fnd.games_store.cart.service.OrderProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController implements  OrderProcessor{


    private final OrderProcessingService service;

    @Autowired
    public OrderController(OrderProcessingService service) {
        this.service = service;
    }


    @Override
    public ResponseEntity<OrderResponseDTO> processOrder() {
        return null;
    }
}
