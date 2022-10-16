package com.fnd.games_store.cart.test.repository;


import com.fnd.games_store.cart.CartApplication;
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


    @Test
    //TODO refactor test name
    void getShoppingSetShouldReturnProperSet(){
//        assertThat(repository.getCartContent("user_1")).isEqualTo(testCart.getShoppingList());
    }


    private void updateCart(){
        List<Game> list = new ArrayList<>(testCart.getShoppingList());
    }



    @BeforeEach
    private void testSetUp(){

        shoppingList.add(createTestGameEntity("1"));
        shoppingList.add(createTestGameEntity("2"));

        testCart.setUserId(userId);
        testCart.setGameId(gameId);
        testCart.setShoppingList(shoppingList);


        log.info("test cart: "+testCart.getShoppingList().toString());
        log.info("repository" + repository.getCartContent("user_1"));

        repository.createCartEntry(testCart);
    }

    @AfterEach
    private void afterTestCleanUp(){
        repository.deleteGameInCart("user_1", "game_1" );
    }


}
