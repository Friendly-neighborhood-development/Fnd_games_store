package com.fnd.games_store.cart.test.repository;


import com.fnd.games_store.cart.CartApplication;
import com.fnd.games_store.cart.entity.Cart;
import com.fnd.games_store.cart.entity.Game;
import com.fnd.games_store.cart.repository.implementation.CartRepository;
import com.fnd.games_store.cart.test.utilities.TestUtilities;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest(classes = CartApplication.class)
@Slf4j
public class AddCartToRedisTest extends TestUtilities {


    @Autowired
    private CartRepository repository;

    private Set<Game> shoppingList = new HashSet<>(3);

    private Cart testCart = new Cart();



    @BeforeEach
    void testSetUp(){

        shoppingList.add(createTestGameEntity("1"));
        shoppingList.add(createTestGameEntity("2"));
        shoppingList.stream().forEach(System.out::println);

        testCart.setUserId(userId);
        testCart.setGameId(gameId);
        testCart.setShoppingSet(shoppingList);

        repository.createCartEntry(testCart);
    }

    @Test
    //TODO refactor test name
    void test1(){
        assertThat(testCart).isEqualTo(repository.getCartByUserId("user_1", "game_1"));
    }




    @AfterEach
    void afterTestCleanUp(){
        repository.deleteCartById("user_1","game_1");
    }


}
