package com.fnd.games_store.login.jwt_utils.implementation;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import com.fnd.games_store.login.exception.BadTokenCredentialsException;
import com.fnd.games_store.login.exception.JwtVerificationException;
import com.fnd.games_store.login.jwt_utils.JwtValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class JwtValidatorImpl implements JwtValidator {

    @Value("${variables.security.access_secret}")
    private String jwtAccessSecret;


    @Override
    public Boolean validateJwtToken(String token) {
        Boolean isTokenValid = false;

        if (verifyTokenSignature(token) && verifyTokenCredentials(token)) {
            isTokenValid = true;
        } else throw new JwtVerificationException("Token has not been verified");
        return isTokenValid;
    }

    private Boolean verifyTokenSignature(String token) {

        Boolean isTokenValid = false;

        Verification verifier = JWT.require(Algorithm.HMAC256(jwtAccessSecret));

        try {
            verifier.build().verify(parseToken(token));
            isTokenValid = true;
        } catch (JwtVerificationException e) {
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
        } else throw new BadTokenCredentialsException("Bad token credentials");
        return isTokenValid;

    }

    private String getUsernameFromToken(String token) {
//        log.info("header "+parseToken(token).getHeader());
        log.info("user " + parseToken(token).getClaims());
        return parseToken(token).getSubject();
    }



    private DecodedJWT parseToken(String token) {
        return JWT.decode(token);
    }


}
