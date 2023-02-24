package com.fnd.games_store.orders.exception;

public class UserValidationFailedException extends RuntimeException{

    public UserValidationFailedException(String message) {
        super(message);
    }
}
