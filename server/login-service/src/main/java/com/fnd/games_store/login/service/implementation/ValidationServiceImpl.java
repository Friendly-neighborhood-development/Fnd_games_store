package com.fnd.games_store.login.service.implementation;

import com.fnd.games_store.login.jwt_utils.JwtValidator;
import com.fnd.games_store.login.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidationServiceImpl implements ValidationService {

    private final JwtValidator jwtValidator;

    @Autowired
    public ValidationServiceImpl(JwtValidator jwtValidator) {
        this.jwtValidator = jwtValidator;
    }

    @Override
    public Boolean validate(String token) {
        return jwtValidator.validateJwtToken(token);
    }
}
