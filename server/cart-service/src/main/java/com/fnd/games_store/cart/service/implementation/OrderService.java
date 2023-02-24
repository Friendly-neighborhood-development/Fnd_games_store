package com.fnd.games_store.cart.service.implementation;

import com.fnd.games_store.cart.dto.CartResponseDTO;
import com.fnd.games_store.cart.dto.OrderDTO;
import com.fnd.games_store.cart.entity.Cart;
import com.fnd.games_store.cart.exception.CartNotFoundException;
import com.fnd.games_store.cart.repository.CartRepository;
import com.fnd.games_store.cart.service.OrderProcessingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class OrderService implements OrderProcessingService {


    private final CartRepository repository;

    private final KafkaTemplate<String, OrderDTO> kafkaTemplate;

    @Autowired
    public OrderService(CartRepository repository, KafkaTemplate<String, OrderDTO> kafkaTemplate) {
        this.repository = repository;
        this.kafkaTemplate = kafkaTemplate;
    }


    @Override
    public CartResponseDTO purchaseGames(String userId) {


        Cart erasedCartData = eraseCart(userId).get();

        OrderDTO messageToOrdersService = new OrderDTO(erasedCartData);

        sendMessage("order-stream", messageToOrdersService);


        return new CartResponseDTO(erasedCartData);
    }


    private Optional<Cart> eraseCart(String userId) {

        Optional<Cart> foundCartData = repository.findById(userId);

        if (foundCartData.isPresent()){
            repository.deleteById(userId);
        } else throw new CartNotFoundException("Cart not found");

        return foundCartData;
    }

    private void confirmPurchase(String userId){

    }

    private void sendMessage(String topicName, OrderDTO orderData) {
        kafkaTemplate.send(topicName, orderData);
        log.info(topicName + " has been sent");
    }
}
