package com.fnd.games_store.login.jwt_utils;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtGenerator {

    public String generateToken(UserDetails userDetails);

}
