package com.fnd.games_store.orders.service;


import com.fnd.games_store.orders.OrdersApplication;
import com.fnd.games_store.orders.dto.OrderRequestDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;
@Transactional
@SpringBootTest(classes = OrdersApplication.class)
public class SaveInitialOrderDataTest extends ServiceTestUtils{

    @Test
    void saveOrder_ShouldCreateInitialOrderEntry(){
        assertThat(savedOrder).isEqualTo(expectedOrder);
    }

    @BeforeEach
    void testSetup(){

        savedOrder.setIsOrderProcessed(true);
        savedOrder.setUserId(userId);
        savedOrder.setOrderDate(testCaseInitTime);

        savedOrder.setGames(testgameList);

        OrderRequestDTO incomingOrderDto = wrapOrderToDto(savedOrder);

        String savedOrderId = service.saveOrder(incomingOrderDto);

        savedOrder.setId(savedOrderId);

        expectedOrder = orderRepository.findById(savedOrderId).get();

    }


}
