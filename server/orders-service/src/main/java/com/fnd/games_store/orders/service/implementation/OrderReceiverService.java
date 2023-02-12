package com.fnd.games_store.orders.service.implementation;

import com.fnd.games_store.orders.dto.OrderDTO;
import com.fnd.games_store.orders.service.OrderMessageListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderReceiverService implements OrderMessageListener {




    @Override
    @KafkaListener(topics = "order-stream", groupId = "orders")
    public void orderMessageListener(OrderDTO order) {
        log.info(order.toString());
    }
}
