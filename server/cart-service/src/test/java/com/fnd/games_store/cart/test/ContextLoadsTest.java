package com.fnd.games_store.cart.test;


import com.fnd.games_store.cart.CartApplication;
import com.fnd.games_store.cart.controller.implementation.CartController;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = CartApplication.class)
public class ContextLoadsTest {


    @Autowired
    CartController controller;


    @Test
    void isContextLoads(){
        assertThat(controller).isNotNull();
    }





}
