package com.fnd.games_store.cart.test.repository;


import com.fnd.games_store.cart.CartApplication;
import com.fnd.games_store.cart.entity.Cart;
import com.fnd.games_store.cart.repository.CartRepository;
import com.fnd.games_store.cart.test.utilities.RepositoryTestUtilities;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = CartApplication.class)
@Slf4j
public class GetCartContentTest extends RepositoryTestUtilities {

    @Autowired
    CartRepository repository;


   @Test
    void getCartContent_ShouldReturnProperContent(){
       assertThat(repository.findById(userId)).get().isEqualTo(testCart);
    }

    @BeforeEach
    void testSetup(){
        testCart.setUserId(userId);
        testCart.setGameData(createTestGameEntity("1"));

        repository.save(testCart);

    }

    @AfterEach
    void afterTestCleanup(){
        repository.deleteAll();
    }


 }
