package com.fnd.games_store.login.jwt_utils.implementation;

import com.fnd.games_store.login.entity.Authority;
import com.fnd.games_store.login.jwt_utils.JwtGenerator;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator.Builder;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.mapping.Attributes2GrantedAuthoritiesMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class JwtGeneratorImpl implements JwtGenerator {

    @Value("${variables.security.access_secret}")
    private String jwtAccessSecret;

    @Value("${variables.security.access_expiration}")
    private Long accessTokenExpirationDuration;


    @Override
    public String generateJwtToken(UserDetails userDetails) {

        Builder builder = JWT.create().withSubject(userDetails.getUsername());


        List<GrantedAuthority> list = new ArrayList<>();
        list.addAll(userDetails.getAuthorities());



        Map<String, Object> payLoad = new HashMap<>();

        payLoad.put("authorities", list);

        return builder.withIssuedAt(new Date()).withExpiresAt(new Date(System.currentTimeMillis() + accessTokenExpirationDuration))
                .withSubject(userDetails.getUsername())
                .withHeader(payLoad)
                .sign(Algorithm.HMAC256(jwtAccessSecret));
    }

    @Profile("test")
    public String getJwtAccessSecret() {
        return jwtAccessSecret;
    }
    @Profile("test")
    public Long getAccessTokenExpirationDuration() {
        return accessTokenExpirationDuration;
    }
}
