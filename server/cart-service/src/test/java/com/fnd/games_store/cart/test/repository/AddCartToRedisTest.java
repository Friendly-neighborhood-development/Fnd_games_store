package com.fnd.games_store.cart.test.repository;


import com.fnd.games_store.cart.CartApplication;
import com.fnd.games_store.cart.test.utilities.TestUtilities;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = CartApplication.class)
@Slf4j
public class AddCartToRedisTest extends TestUtilities {



    @BeforeEach
    void testSetUp(){

        shoppingList.add(createTestGameEntity("1"));
        shoppingList.add(createTestGameEntity("2"));

        testCart.setUserId(userId);
        testCart.setGameId(gameId);
        testCart.setShoppingSet(shoppingList);

        repository.createCartEntry(testCart);
    }

    @Test
    //TODO refactor test name
    void getShoppingSetShouldReturnProperSet(){
        assertThat(testCart.getShoppingSet()).isEqualTo(repository.getCartByUserId("user_1", "game_1"));
    }


    @AfterEach
    void afterTestCleanUp(){
        repository.deleteCartById("user_1","game_1");
    }


}
