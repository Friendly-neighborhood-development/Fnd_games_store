package com.fnd.games_store.login.controller;

import com.fnd.games_store.login.dto.ValidationResponseDTO;
import org.springframework.http.ResponseEntity;

public interface UserValidation {

    public ResponseEntity<ValidationResponseDTO> validateUser(String authHeader);


}
