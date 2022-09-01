package com.fnd.games_store.users.jwt_utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;


@Component
@Slf4j
public class JwtValidator {

    @Value("${variable.settings.security.access_secret}")
    private String jwtAccessSecret;


    public Boolean validateToken(String token) {

        Boolean isTokenValid = false;

        if (verifyTokenSignature(token) && verifyTokenCredentials(token)) {
            isTokenValid = true;
            log.warn("token verification for user: "+ getUsernameFromToken(token) +" with expiration date: " + parseToken(token).getExpiresAt() + " completed succesfully");
        } else throw new RuntimeException("Token has not been verified");

        return isTokenValid;

    }


    public String getUsernameFromToken(String token) {
        return parseToken(token).getSubject();
    }


    private Boolean verifyTokenSignature(String token) {

        Boolean isTokenValid = false;

        try {
            Verification verifier = JWT.require(Algorithm.HMAC256(jwtAccessSecret));

            verifier.build().verify(parseToken(token));

            isTokenValid = true;

        } catch (RuntimeException e) {
            e.printStackTrace();

        }

        return isTokenValid;
    }

    private Boolean verifyTokenCredentials(String token) {

        String username = getUsernameFromToken(token);
        DecodedJWT parsedToken = parseToken(token);
        Boolean isTokenValid = false;
        Boolean isTokenExpired = parsedToken.getExpiresAt().after(parsedToken.getIssuedAt());
        Boolean isUsernameValid = parsedToken.getSubject().equals(username);

        if (isTokenExpired && isUsernameValid) {
            isTokenValid = true;

        } else throw new RuntimeException("Bad token credentials");

        return isTokenValid;

    }



    private DecodedJWT parseToken(String token) {
        return JWT.decode(token);
    }



}
