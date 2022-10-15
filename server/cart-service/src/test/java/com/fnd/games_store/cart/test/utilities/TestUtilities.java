package com.fnd.games_store.cart.test.utilities;

import com.fnd.games_store.cart.entity.Game;

import java.math.BigDecimal;

public class TestUtilities {


    protected String userId = "user_1";

    protected String gameId = "game_1";


    protected TestUtilities() {

    }

    protected Game createTestGameEntity(String differenceParameter){
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
