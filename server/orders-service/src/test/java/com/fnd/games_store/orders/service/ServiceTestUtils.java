package com.fnd.games_store.orders.service;

import com.fnd.games_store.orders.dto.OrderRequestDTO;
import com.fnd.games_store.orders.entity.Game;
import com.fnd.games_store.orders.entity.Order;
import com.fnd.games_store.orders.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
@Slf4j
public class ServiceTestUtils {

    @Autowired
    protected OrderRepository orderRepository;

    @Autowired
    protected OrderSaver service;

    protected String userId = "user1";

    protected Order savedOrder = new Order();

    protected Order expectedOrder = new Order();

    protected OffsetDateTime testCaseInitTime = OffsetDateTime.now();


    protected Game createTestGameEntity(String differenceParameter){

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

    protected OrderRequestDTO wrapOrderToDto(Order wrapableOrder){
        log.info(wrapableOrder.getOrderDate().toString());
        return new OrderRequestDTO(wrapableOrder);
    }



}
