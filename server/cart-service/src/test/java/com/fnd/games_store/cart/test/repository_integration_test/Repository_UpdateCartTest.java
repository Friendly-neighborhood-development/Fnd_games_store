package com.fnd.games_store.cart.test.repository_integration_test;

import com.fnd.games_store.cart.CartApplication;
import com.fnd.games_store.cart.test.utilities.RepositoryTestUtilities;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

//@Slf4j
//@SpringBootTest(classes = CartApplication.class)
public class Repository_UpdateCartTest extends RepositoryTestUtilities {



//    @Test
    void updateCart_shouldNotReturnUpdatedGameSet(){

        testCartGameData.add(createTestGameEntity("2"));
        testCart.setGameData(testCartGameData);
        repository.save(testCart);


//        log.info(repository.findById(userId).get().toString());
//        log.info(testCart.toString());

        assertThat(repository.findById(userId)).get().isEqualTo(testCart);



    }

//    @BeforeEach
    void testSetup(){
        testCart.setUserId(userId);
        testCartGameData.add(createTestGameEntity("1"));
        testCart.setGameData(testCartGameData);

        repository.save(testCart);

    }




}
