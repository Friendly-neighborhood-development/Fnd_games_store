package com.fnd.games_store.orders;


import com.fnd.games_store.orders.service.OrderMessageListener;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = OrdersApplication.class)
public class ContextLoads {



    @Autowired
    private OrderMessageListener service;

    @Test
    void contextLoadsTest(){
        assertThat(service).isNotNull();
    }


}
