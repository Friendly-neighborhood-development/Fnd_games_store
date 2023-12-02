package com.fnd.games_store.cart.test.repository_integration_test;


import com.fnd.games_store.cart.test.utilities.RepositoryTestUtilities;

import com.fnd.games_store.cart.CartApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.DockerImageName;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = CartApplication.class)
@Slf4j
public class Repository_DeleteGameTest extends RepositoryTestUtilities {

    @Test
    void deleteGameInCart_ShouldDeleteGameEntry(){

//        testCartGameData.remove((createTestGameEntity("1")));
//        repository.save(testCart);
//
//        assertThat(repository.findById(userId).get()).isEqualTo(testCart);

//        log.info("cart persisted in db: "+repository.findById(userId).get().toString());
//        log.info("updated cart: "+testCart.toString());

    }


//    @BeforeEach
    void testSetup(){
        testCart.setUserId(userId);
        testCartGameData.add(createTestGameEntity("1"));
        testCart.setGameData(testCartGameData);

        testCartGameData.add(createTestGameEntity("2"));
        testCart.setGameData(testCartGameData);

        repository.save(testCart);

    }


}
