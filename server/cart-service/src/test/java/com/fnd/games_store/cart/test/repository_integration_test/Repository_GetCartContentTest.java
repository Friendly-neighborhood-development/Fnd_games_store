package com.fnd.games_store.cart.test.repository_integration_test;


import com.fnd.games_store.cart.CartApplication;
import com.fnd.games_store.cart.repository.CartRepository;
import com.fnd.games_store.cart.test.utilities.RepositoryTestUtilities;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;


import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = CartApplication.class)
@Slf4j
@Testcontainers(disabledWithoutDocker = true)
public class Repository_GetCartContentTest extends RepositoryTestUtilities {

    @Autowired
    CartRepository repository;


   @Test
    void getCartContent_ShouldReturnSavedTestCart(){
       log.info(repository.findById(userId).get().toString());
       log.info(testCart.toString());

       assertThat(repository.findById(userId)).get().isEqualTo(testCart);
    }

    @BeforeEach
    void testSetup(){
        testCart.setUserId(userId);
        testCartGameData.add(createTestGameEntity("1"));
        testCart.setGameData(testCartGameData);

        repository.save(testCart);

    }




 }
