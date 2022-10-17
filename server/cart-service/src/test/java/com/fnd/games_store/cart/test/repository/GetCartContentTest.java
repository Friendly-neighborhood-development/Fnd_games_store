package com.fnd.games_store.cart.test.repository;


import com.fnd.games_store.cart.CartApplication;
import com.fnd.games_store.cart.entity.Cart;
import com.fnd.games_store.cart.entity.Game;
import com.fnd.games_store.cart.repository.implementation.CartRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.SpringVersion;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = CartApplication.class)
@Slf4j
public class GetCartContentTest {

    protected String userId = "user_1";

    protected String gameId = "game_1";

    protected List<Game> testGameList = new ArrayList<>();

    @Autowired
    protected CartRepository repository;

    protected Cart testCart = new Cart();


    @Test
    void getCartContent_ShouldReturnProperContent(){
        assertThat(testGameList).isEqualTo(repository.getCartContent(userId));
    }

    @BeforeEach
    void testSetUp(){


        testCart.setUserId(userId);
        testCart.setGameId(gameId);
        testCart.setGameData(createTestGameEntity("1"));




        testGameList.add(createTestGameEntity("1"));

        repository.createCartEntry(testCart);


        log.info(SpringVersion.getVersion());
        log.info("test cart: "+testCart.getGameData().toString());
        log.info("test cart list: "+ testGameList.toString());
        log.info("repository" + repository.getCartContent(userId));


    }

    @AfterEach
    void afterTestCleanUp(){
        repository.deleteGameInCart(userId, userId);
    }

    private Game createTestGameEntity(String differenceParameter){
        Game game = new Game();
        game.setName("name" + differenceParameter);
        game.setGenre("genre" + differenceParameter);
        game.setReleaseDate("date" + differenceParameter);
        game.setDeveloper("developer" + differenceParameter);
        game.setPublisher("publisher" + differenceParameter);
        game.setPlatform("platform" + differenceParameter);
        game.setFeatures("features" + differenceParameter);
        game.setPrice(BigDecimal.valueOf(1000));
        game.setDiscount(BigDecimal.valueOf(200));
        game.setDescription("description" + differenceParameter);
        game.setBase64Image("image" + differenceParameter);
        return game;
    }
}
