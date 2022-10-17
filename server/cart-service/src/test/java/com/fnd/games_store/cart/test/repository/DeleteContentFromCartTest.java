package com.fnd.games_store.cart.test.repository;

import com.fnd.games_store.cart.repository.implementation.CartRepository;
import com.fnd.games_store.cart.test.utilities.TestUtilities;

import com.fnd.games_store.cart.CartApplication;
import com.fnd.games_store.cart.test.utilities.TestUtilities;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest(classes = CartApplication.class)
public class DeleteContentFromCartTest extends TestUtilities {


    @Autowired
    private CartRepository repository;

//    @Test
    void deleteGameInCart_ShouldDeleteGameEntry(){

    }

    @BeforeEach
    private void testSetUp(){

        testGameList.add(createTestGameEntity("1"));
        testGameList.add(createTestGameEntity("2"));



//        repository.createCartEntry();

    }


}
