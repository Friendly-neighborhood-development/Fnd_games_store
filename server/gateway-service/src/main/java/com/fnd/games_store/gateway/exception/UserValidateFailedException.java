package com.fnd.games_store.gateway.exception;

public class UserValidateFailedException extends RuntimeException{

    public UserValidateFailedException(String message) {
        super(message);
    }
}
