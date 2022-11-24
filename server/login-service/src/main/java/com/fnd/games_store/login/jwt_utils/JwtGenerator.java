package com.fnd.games_store.login.jwt_utils;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;

public interface JwtGenerator {

    public String generateJwtToken(UserDetails userDetails);

}
