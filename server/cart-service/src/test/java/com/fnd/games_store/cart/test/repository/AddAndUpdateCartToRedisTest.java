package com.fnd.games_store.cart.test.repository;


import com.fnd.games_store.cart.CartApplication;
import com.fnd.games_store.cart.entity.Cart;
import com.fnd.games_store.cart.entity.Game;
import com.fnd.games_store.cart.test.utilities.TestUtilities;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = CartApplication.class)
@Slf4j
public class AddAndUpdateCartToRedisTest extends TestUtilities {





    List<Game> testGameList = new ArrayList<>();

    @Test
    void getShoppingSetShouldReturnProperSet(){
        assertThat(repository.getCartContent(userId)).isEqualTo(testGameList);
    }


    private void updateCart(){
//        List<Game> list = new ArrayList<>(testCart.getShoppingList());
    }



    @BeforeEach
    private void testSetUp(){

        testGameList.add(createTestGameEntity("1"));

        repository.createCartEntry(testCart);

        log.info("test cart: "+testCart.getGameData().toString());
        log.info("test cart list: "+ testGameList.toString());
        log.info("repository" + repository.getCartContent(userId));


    }

    @AfterEach
    private void afterTestCleanUp(){
        repository.deleteGameInCart(userId, userId);
    }


}
