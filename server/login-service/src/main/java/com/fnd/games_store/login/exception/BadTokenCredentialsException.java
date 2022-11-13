package com.fnd.games_store.login.exception;

public class BadTokenCredentialsException extends RuntimeException{
    public BadTokenCredentialsException(String message) {
        super(message);
    }
}
