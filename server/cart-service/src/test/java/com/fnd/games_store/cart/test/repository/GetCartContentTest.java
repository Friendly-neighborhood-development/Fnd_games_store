package com.fnd.games_store.cart.test.repository;


import com.fnd.games_store.cart.CartApplication;
import com.fnd.games_store.cart.test.utilities.RepositoryTestUtilities;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.SpringVersion;


import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = CartApplication.class)
@Slf4j
public class GetCartContentTest extends RepositoryTestUtilities {

   @Test
    void getCartContent_ShouldReturnProperContent(){
        assertThat(testGameList).isEqualTo(repository.getCartContent(userId));
    }

    @BeforeEach
    void testSetup(){

        testCart.setUserId(userId);
        testCart.setGameId(gameId);
        testCart.setGameData(createTestGameEntity("1"));

        testGameList.add(createTestGameEntity("1"));

        repository.updateCart(testCart);

        log.info(SpringVersion.getVersion());
        log.info("test cart: "+testCart.getGameData().toString());
        log.info("repository" + repository.getCartContent(userId));

    }

    @AfterEach
    void afterTestCleanUp(){
        repository.deleteGameEntry(userId, gameId);
    }

 }
