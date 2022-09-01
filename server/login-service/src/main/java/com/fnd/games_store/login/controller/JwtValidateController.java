package com.fnd.games_store.login.controller;

import org.springframework.http.ResponseEntity;

public interface JwtValidateController {

    public ResponseEntity<Boolean> validateToken(String token);

}
