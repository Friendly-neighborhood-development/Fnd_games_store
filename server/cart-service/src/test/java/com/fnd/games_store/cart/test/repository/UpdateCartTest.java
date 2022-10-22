package com.fnd.games_store.cart.test.repository;

import com.fnd.games_store.cart.CartApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest(classes = CartApplication.class)
public class UpdateCartTest extends GetCartContentTest {



    @Test
    void updateCart_shouldNotReturnUpdatedGameSet(){

        testCartGameData.add(createTestGameEntity("2"));
        testCart.setGameData(testCartGameData);
        repository.save(testCart);


        log.info(repository.findById(userId).get().toString());
        log.info(testCart.toString());

        assertThat(repository.findById(userId)).get().isEqualTo(testCart);

    }





}
