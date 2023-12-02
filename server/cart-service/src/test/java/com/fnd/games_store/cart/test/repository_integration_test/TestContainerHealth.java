package com.fnd.games_store.cart.test.repository_integration_test;


import com.fnd.games_store.cart.CartApplication;
import com.fnd.games_store.cart.test.utilities.RepositoryTestUtilities;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.Assert.assertTrue;

@SpringBootTest(classes = CartApplication.class)
@Testcontainers(disabledWithoutDocker = true)
public class TestContainerHealth extends RepositoryTestUtilities {

    @Test
    void givenRedisContainerConfiguredWithDynamicProperties_whenCheckingRunningStatus_thenStatusIsRunning() {
        assertTrue(REDIS_CONTAINER.isRunning());
    }

}
