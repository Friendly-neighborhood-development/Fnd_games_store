package com.fnd.games_store.orders.service;


import com.fnd.games_store.orders.OrdersApplication;
import com.fnd.games_store.orders.dto.OrderRequestDTO;
import com.fnd.games_store.orders.entity.Game;
import com.fnd.games_store.orders.entity.Order;
import com.fnd.games_store.orders.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
@Transactional
@SpringBootTest(classes = OrdersApplication.class)
@Slf4j
public class SaveOrderTest {


    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderSaver service;

    private String userId = "user1";

    private Order savedOrder = new Order();

    private Order expectedOrder = new Order();

    private OffsetDateTime testCaseInitTime = OffsetDateTime.now();


    @Test
    void saveOrder_ShouldSaveProperOrderEntity(){
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





    private Game createTestGameEntity(String differenceParameter){

        Game testGameEntity = new Game();
        testGameEntity.setId(differenceParameter);
        testGameEntity.setName("Doom Eternal" + differenceParameter);
        testGameEntity.setReleaseDate("2009"+differenceParameter);
        testGameEntity.setPrice(BigDecimal.valueOf(1000));
        testGameEntity.setDiscount(BigDecimal.valueOf(20));
        testGameEntity.setDescription(""+differenceParameter);
        testGameEntity.setBase64Image(""+differenceParameter);

        return testGameEntity;
    }

    private OrderRequestDTO wrapOrderToDto(Order wrapableOrder){
        log.info(wrapableOrder.getOrderDate().toString());
        return new OrderRequestDTO(wrapableOrder);
    }

}
