package com.fnd.games_store.orders.service;


import com.fnd.games_store.orders.OrdersApplication;
import com.fnd.games_store.orders.entity.Game;
import com.fnd.games_store.orders.entity.Order;
import com.fnd.games_store.orders.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@Transactional
@SpringBootTest(classes = OrdersApplication.class)
@Slf4j
public class SaveOrderTest {


    @Autowired
    private OrderRepository orderRepository;

    private String userId = "user1";

    @Test
    void saveOrder_ShouldSaveProperOrderEntity(){
//        assertThat(testOrderEntity).isEqualTo(expectedOrderEntity);
    }




    @BeforeEach
    void testSetup(){

        Order expectedOrderEntity = new Order();

        List<Game> testgameList = new ArrayList<>();
        testgameList.add(createTestGameEntity("1"));
        testgameList.add(createTestGameEntity("2"));

        expectedOrderEntity.setIsOrderProcessed(true);
        expectedOrderEntity.setUserId(userId);

        expectedOrderEntity.setGames(testgameList);

        orderRepository.save(expectedOrderEntity);

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
