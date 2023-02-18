package com.fnd.games_store.orders.service;


import com.fnd.games_store.orders.OrdersApplication;
import com.fnd.games_store.orders.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;

@SpringBootTest(classes = OrdersApplication.class)
public class SaveOrderTest {






    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private EntityManager entityManager;











    @BeforeEach
    void testSetup(){







    }



}
