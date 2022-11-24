package com.fnd.games_store.login.exception;

public class JwtVerificationException extends RuntimeException{

    public JwtVerificationException(String message) {
        super(message);
    }
}
