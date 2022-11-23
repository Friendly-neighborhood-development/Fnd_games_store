package com.fnd.games_store.login.jwt_utils;

public interface JwtAuthorityValidator {

    public Boolean validateJwtTokenAuthorities(String token);

}
