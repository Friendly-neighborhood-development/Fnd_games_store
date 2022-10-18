package com.fnd.games_store.cart.test.repository;


import com.fnd.games_store.cart.test.utilities.TestUtilities;

import com.fnd.games_store.cart.CartApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = CartApplication.class)
@Slf4j
public class DeleteGameTest extends TestUtilities {



    @Test
    void deleteGameInCart_ShouldDeleteGameEntry(){
        repository.deleteGameEntry(userId, "game_2");
        log.info(repository.getCartContent(userId).toString());
        log.info(testGameList.get(0).toString());
        assertThat(repository.getCartContent(userId).get(0)).isEqualTo(testGameList.get(0));
    }

    @BeforeEach
    void testSetUp(){

        testCart.setUserId(userId);
        testCart.setGameId(gameId);
        testCart.setGameData(createTestGameEntity("1"));

        testGameList.add(createTestGameEntity("1"));
        testGameList.add(createTestGameEntity("2"));

        repository.createCartEntry(testCart);

        testCart.setGameId("game_2");
        testCart.setGameData(createTestGameEntity("2"));

        repository.createCartEntry(testCart);

        log.info(repository.getCartContent(userId).toString());

    }

    @AfterEach
    void afterTestCleanUp(){
        repository.deleteGameEntry(userId, gameId);
        repository.deleteGameEntry(userId, "game_2");
    }







}
