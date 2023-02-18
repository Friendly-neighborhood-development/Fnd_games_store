package com.fnd.games_store.orders.service;


import com.fnd.games_store.orders.OrdersApplication;
import com.fnd.games_store.orders.entity.Game;
import com.fnd.games_store.orders.entity.Order;
import com.fnd.games_store.orders.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
@Transactional
@SpringBootTest(classes = OrdersApplication.class)
public class SaveOrderTest {


    @Autowired
    private OrderRepository orderRepository;

    private Order testOrderEntity;

    private Order expectedOrderEntity;

    private String userId = "user1";

    @Test
    void saveOrder_ShouldSaveProperOrderEntity(){
        assertThat(testOrderEntity).isEqualTo(expectedOrderEntity);
    }




    @BeforeEach
    void testSetup(){

        orderRepository.save(testOrderEntity);

        expectedOrderEntity = orderRepository.findById(userId).get();

    }



    private void initTestOrderEntity(){

        testOrderEntity = new Order();

        testOrderEntity.addGame(createTestGameEntity("0"));
        testOrderEntity.addGame(createTestGameEntity("1"));
        testOrderEntity.setIsOrderProcessed(true);
        testOrderEntity.setUserId(userId);

    }


    private Game createTestGameEntity(String differenceParameter){

        Game testGameEntity = new Game();

        testGameEntity.setName("Doom Eternal" + differenceParameter);
        testGameEntity.setReleaseDate("2009"+differenceParameter);
        testGameEntity.setPrice(BigDecimal.valueOf(1000));
        testGameEntity.setDiscount(BigDecimal.valueOf(20));
        testGameEntity.setDescription(""+differenceParameter);
        testGameEntity.setBase64Image(""+differenceParameter);

        return testGameEntity;
    }



}
