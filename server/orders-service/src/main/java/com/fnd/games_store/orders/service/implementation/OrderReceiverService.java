package com.fnd.games_store.orders.service.implementation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fnd.games_store.orders.dto.OrderRequestDTO;
import com.fnd.games_store.orders.service.OrderMessageListener;
import com.fnd.games_store.orders.service.OrderSaver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderReceiverService implements OrderMessageListener {


    private final ObjectMapper objectMapper;

    private final OrderSaver service;

    @Autowired
    public OrderReceiverService(ObjectMapper objectMapper, OrderSaver service) {
        this.objectMapper = objectMapper;
        this.service = service;
    }
    @Override
    @KafkaListener(topics = "order-stream", groupId = "orders")
    public void orderMessageListener(String order)  {

        OrderRequestDTO restoredObject;

        try{
            restoredObject = objectMapper.readValue(order, OrderRequestDTO.class);
            service.saveOrder(restoredObject);
            log.info(restoredObject.toString());
        } catch( JsonProcessingException e){
            e.printStackTrace();
        }

    }
}
