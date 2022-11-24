package com.fnd.games_store.login.service.implementation;

import com.fnd.games_store.login.jwt_utils.JwtValidator;
import com.fnd.games_store.login.service.ValidationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class ValidationServiceImpl implements ValidationService {

    private final JwtValidator jwtValidator;

    @Autowired
    public ValidationServiceImpl(JwtValidator jwtValidator) {
        this.jwtValidator = jwtValidator;
    }

    @Override
    public Boolean validate(String token) {
        log.info(token);
        return jwtValidator.validateJwtToken(token.substring(7));
    }
}
