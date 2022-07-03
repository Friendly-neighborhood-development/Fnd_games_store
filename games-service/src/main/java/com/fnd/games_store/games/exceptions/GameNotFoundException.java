package com.fnd.games_store.games.exceptions;

public class GameNotFoundException extends RuntimeException{


    public GameNotFoundException() {
        super("Requested game not found");
    }
}
