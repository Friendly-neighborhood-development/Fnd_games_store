package com.fnd.games_store.orders.service;


import com.fnd.games_store.orders.OrdersApplication;
import com.fnd.games_store.orders.entity.Game;
import com.fnd.games_store.orders.entity.Order;
import com.fnd.games_store.orders.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

@SpringBootTest(classes = OrdersApplication.class)
public class SaveOrderTest {


    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private EntityManager entityManager;

    private Order testOrderEntity;








    @BeforeEach
    void testSetup(){









    }



    private void initTestOrderEntity(){






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
