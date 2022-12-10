package com.fnd.games_store.cart.test.utilities;

import com.fnd.games_store.cart.entity.Cart;
import com.fnd.games_store.cart.entity.Game;
import com.fnd.games_store.cart.repository.CartRepository;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class RepositoryTestUtilities {
    @Autowired
    protected CartRepository repository;

    protected String userId = "user_1";


    protected List<Game> testCartGameData= new ArrayList<>();

    protected Cart testCart = new Cart();

    protected RepositoryTestUtilities() {

    }

    protected Game createTestGameEntity(String differenceParameter){
        Game game = new Game();
        game.setId("id"+ differenceParameter);
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

    @AfterEach
    protected void afterTestCleanup(){
        repository.deleteAll();
    }








}
