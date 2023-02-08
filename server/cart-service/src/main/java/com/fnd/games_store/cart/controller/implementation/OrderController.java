package com.fnd.games_store.cart.controller.implementation;


import com.fnd.games_store.cart.controller.OrderProcessor;
import com.fnd.games_store.cart.dto.OrderResponseDTO;
import com.fnd.games_store.cart.service.OrderProcessingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderController implements  OrderProcessor{


    private final OrderProcessingService service;

    @Autowired
    public OrderController(OrderProcessingService service) {
        this.service = service;
    }


    @Override
    @PostMapping("v1/purchase/{userId}")
    public ResponseEntity<OrderResponseDTO> processOrder(@PathVariable String userId) {


        log.info(userId);

        service.purchaseGames(userId);

        return null;
    }
}
