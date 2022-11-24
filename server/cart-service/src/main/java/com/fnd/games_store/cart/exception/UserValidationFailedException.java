package com.fnd.games_store.cart.exception;

public class UserValidationFailedException extends RuntimeException{

    public UserValidationFailedException(String message) {
        super(message);
    }
}
