package com.fnd.games_store.login.controller;

import com.fnd.games_store.login.controller.dto.ValidationResponseDTO;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

public interface UserValidation {

//    public ResponseEntity<ValidationResponseDTO> validateUser(HttpServletRequest request);
    public ResponseEntity<ValidationResponseDTO> validateUser(String incomingToken);


}
