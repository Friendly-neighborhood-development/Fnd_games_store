package com.fnd.games_store.orders.service;

import com.fnd.games_store.orders.OrdersApplication;
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
public class FetchOrderDataTest extends ServiceTestUtils {


    private OffsetDateTime testCaseInitTime = OffsetDateTime.now();


    @Test
    void saveOrder_ShouldCreateInitialOrderEntry(){
        OffsetDateTime timeNow = OffsetDateTime.now();

        savedOrder.setOrderDate(timeNow);
        expectedOrder.setOrderDate(timeNow);
        savedOrder.setId(expectedOrder.getId());

        log.info("saved order: "+savedOrder.getId());
        log.info("expected order: "+expectedOrder.getId());

        assertThat(savedOrder).isEqualTo(expectedOrder);
    }




    @BeforeEach
    void testSetup(){

        savedOrder.setIsOrderProcessed(true);
        savedOrder.setUserId(userId);
        savedOrder.setOrderDate(testCaseInitTime);

        testgameList.add(createTestGameEntity("1"));

        savedOrder.setGames(testgameList);

        service.saveOrder(wrapOrderToDto(savedOrder));

        expectedOrder = orderRepository.findOrdersByUserId(userId).get().get(0);

    }



}
