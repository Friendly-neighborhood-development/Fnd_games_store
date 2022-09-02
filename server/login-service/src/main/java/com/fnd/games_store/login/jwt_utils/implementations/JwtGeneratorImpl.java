package com.fnd.games_store.login.jwt_utils.implementations;

import com.fnd.games_store.login.jwt_utils.JwtGenerator;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator.Builder;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;

@Component
@NoArgsConstructor
@AllArgsConstructor
public class JwtGeneratorImpl implements JwtGenerator {

    @Value("${variables.security.access_secret}")
    private String jwtAccessSecret;

    @Value("${variables.security.access_expiration}")
    private String expirationDuration;

    @Override
    public String generateAccessToken(UserDetails userDetails) {
        Builder builder = JWT.create().withSubject(userDetails.getUsername());

        //TODO need to do something wit deprecated constructor Date()
        return builder.withIssuedAt(new Date()).withExpiresAt(new Date(System.currentTimeMillis() + expirationDuration))
                .withSubject(userDetails.getUsername())
                .sign(Algorithm.HMAC256(jwtAccessSecret));
    }

    @Profile("test")
    public String jwtAccessSecret() {
        return jwtAccessSecret;
    }
    @Profile("test")
    public String getExpirationDuration() {
        return expirationDuration;
    }
}

