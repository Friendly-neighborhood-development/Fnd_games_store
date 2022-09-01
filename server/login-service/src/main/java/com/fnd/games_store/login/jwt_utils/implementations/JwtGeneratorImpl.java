package com.fnd.games_store.login.jwt_utils.implementations;

import com.fnd.games_store.login.jwt_utils.JwtGenerator;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.security.RolesAllowed;

@Component
@NoArgsConstructor
@AllArgsConstructor
public class JwtGeneratorImpl implements JwtGenerator {

    @Value("${variables.security.access_secret}")
    private String secret;

    @Value("${variables.security.access_expiration}")
    private String expirationDuration;

    @Override
    public String generateToken(UserDetails userDetails) {
        return null;
    }

    @Profile("test")
    public String getSecret() {
        return secret;
    }
    @Profile("test")
    public String getExpirationDuration() {
        return expirationDuration;
    }
}

