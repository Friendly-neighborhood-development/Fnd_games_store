package com.fnd.games_store.orders.service;

import com.fnd.games_store.orders.OrdersApplication;
import com.fnd.games_store.orders.dto.OrderRequestDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;

import static org.assertj.core.api.Assertions.assertThat;
@Transactional
@SpringBootTest(classes = OrdersApplication.class)
public class UpdateExistingOrderDataTest extends ServiceTestUtils{


    private OffsetDateTime testCaseInitTime = OffsetDateTime.now();

    @Test
    void saveOrder_ShouldUpdateExistingOrderEntry(){
        assertThat(updatedSavableOrder).isEqualTo(expectedOrder);
    }

    @BeforeEach
    void testSetup(){


        testgameList.add(createTestGameEntity("1"));
        testgameList.add(createTestGameEntity("2"));

        savedOrder.setIsOrderProcessed(true);
        savedOrder.setUserId(userId);
        savedOrder.setOrderDate(testCaseInitTime);
        savedOrder.setGames(testgameList);

        orderRepository.save(savedOrder);

        updatedSavableOrder.setIsOrderProcessed(true);
        updatedSavableOrder.setUserId(userId);
        updatedSavableOrder.setOrderDate(testCaseInitTime);

        testgameList.add(createTestGameEntity("3"));

        OrderRequestDTO incomingOrderDto = wrapOrderToDto(updatedSavableOrder);

        String savedOrderId = service.saveOrder(incomingOrderDto);

        savedOrder.setId(savedOrderId);

        expectedOrder = orderRepository.findById(savedOrderId).get();

    }

}
