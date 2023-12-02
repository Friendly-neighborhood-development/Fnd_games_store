package com.fnd.games_store.cart.test.repository_integration_test;


import com.fnd.games_store.cart.test.utilities.RepositoryTestUtilities;

import com.fnd.games_store.cart.CartApplication;
import com.redis.testcontainers.RedisContainer;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

@SpringBootTest(classes = CartApplication.class)
@Slf4j
@Testcontainers(disabledWithoutDocker = true)
public class Repository_DeleteGameTest extends RepositoryTestUtilities {


    @Container
    private static final RedisContainer REDIS_CONTAINER = new RedisContainer(DockerImageName.parse("redis:5.0.3-alpine")).withExposedPorts(6379);


    @DynamicPropertySource
    private static void registerRedisProperties(DynamicPropertyRegistry registry) {
        registry.add("variables.redis.host", REDIS_CONTAINER::getHost);
        registry.add("variables.redis.port", () -> REDIS_CONTAINER.getMappedPort(6379)
                .toString());
    }


    @Test
    void givenRedisContainerConfiguredWithDynamicProperties_whenCheckingRunningStatus_thenStatusIsRunning() {
        assertTrue(REDIS_CONTAINER.isRunning());
    }


//    @Test
//    void deleteGameInCart_ShouldDeleteGameEntry(){

//        testCartGameData.remove((createTestGameEntity("1")));
//        repository.save(testCart);
//
//        assertThat(repository.findById(userId).get()).isEqualTo(testCart);

//        log.info("cart persisted in db: "+repository.findById(userId).get().toString());
//        log.info("updated cart: "+testCart.toString());

//    }


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
