package com.fnd.games_store.cart.test.repository;


import com.fnd.games_store.cart.CartApplication;
import com.fnd.games_store.cart.entity.Cart;
import com.fnd.games_store.cart.entity.Game;
import com.fnd.games_store.cart.repository.implementation.CartRepository;
import com.fnd.games_store.cart.test.utilities.TestUtilities;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest(classes = CartApplication.class)
public class AddCartToRedisTest extends TestUtilities {


    @Autowired
    private CartRepository repository;


    @BeforeEach
    void testSetUp(){

        Set<Game> shoppingList = new HashSet<>(3);
        shoppingList.add(createTestGameEntity("1"));
        shoppingList.add(createTestGameEntity("2"));

        Cart cart = new Cart("user_1","game_1", shoppingList);

        repository.persistCart(cart);
    }

    @Test
    //TODO refactor test name
    void test1(){

    }




    @AfterEach
    void afterTestCleanUp(){
        repository.deleteCartById("user_1","game_1");
    }


}
