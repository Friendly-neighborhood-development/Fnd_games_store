package com.fnd.games_store.cart.test.repository;

import com.fnd.games_store.cart.CartApplication;
import com.fnd.games_store.cart.test.utilities.TestUtilities;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest(classes = CartApplication.class)
public class UpdateCartTest extends TestUtilities {



    @Test
    void updateCart_shouldNotReturnNotUpdatedList(){

        assertThat(repository.getCartContent(userId)).isNotEqualTo(testGameList);

        log.info(repository.getCartContent(userId).toString());
        log.info(testGameList.toString());

    }

    @Test
    void updateCartShouldReturnUpdatedCart(){

        repository.deleteGameEntry(userId, "game_2");

        log.info(repository.getCartContent(userId).toString());
        log.info(testGameList.toString());
        assertThat(repository.getCartContent(userId)).isEqualTo(testGameList);
    }


    @BeforeEach
    void testSetup(){

        testCart.setUserId(userId);
        testCart.setGameId(gameId);
        testCart.setGameData(createTestGameEntity("1"));
        repository.updateCart(testCart);

        testGameList.add(createTestGameEntity("1"));


        testCart.setGameId("game_2");
        testCart.setGameData(createTestGameEntity("2"));
        repository.updateCart(testCart);

    }


    @AfterEach
    void afterTestCleanup(){
        repository.deleteGameEntry(userId, gameId);

    }



}
