package com.fnd.games_store.games.exceptions;

public class GameNotFoundException extends RuntimeException{


    public GameNotFoundException(String message) {
        super(message);
    }
}
