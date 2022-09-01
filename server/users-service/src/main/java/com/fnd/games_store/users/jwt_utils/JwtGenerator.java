package com.fnd.games_store.users.jwt_utils;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator.Builder;
import com.auth0.jwt.algorithms.Algorithm;

import javax.annotation.PostConstruct;
import java.time.OffsetDateTime;
import java.util.Date;


@Component
@Slf4j
public class JwtGenerator {

    @Value("${variable.settings.security.access_secret}")
    private String accessSecret;

    @Value("${variable.settings.security.access_expiration}")
    private String accessExpiration;



    public String generateAccessToken(UserDetails userDetails) {
        Builder builder = JWT.create().withSubject(userDetails.getUsername());

// TODO do something with deprecated Date() later

        return builder.withIssuedAt(new Date()).withExpiresAt(new Date(System.currentTimeMillis() + accessExpiration))
                .withSubject(userDetails.getUsername())
                .sign(Algorithm.HMAC256(accessSecret));
    }
}
