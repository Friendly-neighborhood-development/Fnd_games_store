package com.fnd.games_store.login.jwt_utils;

public interface JwtValidator {

    public Boolean validateToken(String incomingToken);

}
