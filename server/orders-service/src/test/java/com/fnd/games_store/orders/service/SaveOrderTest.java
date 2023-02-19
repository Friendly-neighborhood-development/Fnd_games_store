package com.fnd.games_store.orders.service;


import com.fnd.games_store.orders.OrdersApplication;
import com.fnd.games_store.orders.dto.OrderRequestDTO;
import com.fnd.games_store.orders.entity.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;



import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
@Transactional
@SpringBootTest(classes = OrdersApplication.class)
public class SaveOrderTest extends ServiceTestUtils{

    @Test
    void saveOrder_ShouldCreateInitialOrderEntry(){
        assertThat(savedOrder.equals(expectedOrder)).isTrue();
    }

    @BeforeEach
    void testSetup(){

        List<Game> testgameList = new ArrayList<>();
        testgameList.add(createTestGameEntity("1"));
        testgameList.add(createTestGameEntity("2"));

        savedOrder.setIsOrderProcessed(true);
        savedOrder.setUserId(userId);
        savedOrder.setOrderDate(testCaseInitTime);

        savedOrder.setGames(new ArrayList<>());

        OrderRequestDTO incomingOrderDto = wrapOrderToDto(savedOrder);

        String savedOrderId = service.saveOrder(incomingOrderDto);

        savedOrder.setId(savedOrderId);

        expectedOrder = orderRepository.findById(savedOrderId).get();

    }


}
