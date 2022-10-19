package com.fnd.games_store.cart.test.repository;


import com.fnd.games_store.cart.test.utilities.RepositoryTestUtilities;

import com.fnd.games_store.cart.CartApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = CartApplication.class)
@Slf4j
public class DeleteGameTest extends RepositoryTestUtilities {



    @Test
    void deleteGameInCart_ShouldDeleteGameEntry(){
        repository.deleteGameEntry(userId, "game_2");
        assertThat(repository.getCartContent(userId).get(0)).isEqualTo(testGameList.get(0));
    }

    @BeforeEach
    void testSetup(){

        testCart.setUserId(userId);
        testCart.setGameId(gameId);
        testCart.setGameData(createTestGameEntity("1"));

        testGameList.add(createTestGameEntity("1"));
        testGameList.add(createTestGameEntity("2"));

        repository.updateCart(testCart);

        testCart.setGameId("game_2");
        testCart.setGameData(createTestGameEntity("2"));

        repository.updateCart(testCart);

        log.info(repository.getCartContent(userId).toString());

    }

    @AfterEach
    void afterTestCleanUp(){
        repository.deleteGameEntry(userId, gameId);
        repository.deleteGameEntry(userId, "game_2");
    }







}
