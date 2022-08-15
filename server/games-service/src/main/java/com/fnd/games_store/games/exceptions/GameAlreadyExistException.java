package com.fnd.games_store.games.exceptions;

public class GameAlreadyExistException extends RuntimeException{
    public GameAlreadyExistException(String message) {
        super(message);
    }
}
