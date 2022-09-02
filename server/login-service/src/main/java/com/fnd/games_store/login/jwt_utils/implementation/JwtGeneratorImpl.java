package com.fnd.games_store.login.jwt_utils.implementation;

import com.fnd.games_store.login.jwt_utils.JwtGenerator;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator.Builder;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class JwtGeneratorImpl implements JwtGenerator {

    @Value("${variables.security.access_secret}")
    private String jwtAccessSecret;

    @Value("${variables.security.access_expiration}")
    private Long accessTokenExpirationDuration;


    @Override
    public String generateJwtToken(UserDetails userDetails) {
        Builder builder = JWT.create().withSubject(userDetails.getUsername());

        return builder.withIssuedAt(new Date()).withExpiresAt(new Date(System.currentTimeMillis() + accessTokenExpirationDuration))
                .withSubject(userDetails.getUsername())
                .sign(Algorithm.HMAC256(jwtAccessSecret));
    }

}
