package com.fnd.games_store.orders.service;


import com.fnd.games_store.orders.OrdersApplication;
import com.fnd.games_store.orders.dto.OrderRequestDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;


import static org.assertj.core.api.Assertions.*;
@Transactional
@SpringBootTest(classes = OrdersApplication.class)
@Slf4j
public class SaveInitialOrderDataTest extends ServiceTestUtils{


    private OffsetDateTime testCaseInitTime = OffsetDateTime.now();

    @Test
    void saveOrder_ShouldCreateInitialOrderEntry(){
        log.info("saved order: "+savedOrder.toString());
        log.info("expected order: "+expectedOrder.toString());
        assertThat(savedOrder).isEqualTo(expectedOrder);
    }

    @BeforeEach
    void testSetup(){

        savedOrder.setIsOrderProcessed(true);
        savedOrder.setUserId(userId);
        savedOrder.setOrderDate(testCaseInitTime);

        testgameList.add(createTestGameEntity("1"));

        savedOrder.setGames(testgameList);

        OrderRequestDTO incomingOrderDto = wrapOrderToDto(savedOrder);

        String savedOrderId = service.saveOrder(incomingOrderDto);

        savedOrder.setId(savedOrderId);

        expectedOrder = orderRepository.findById(savedOrderId).get();

    }


}
