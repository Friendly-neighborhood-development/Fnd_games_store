package com.fnd.games_store.login.controller;

import com.fnd.games_store.login.controller.dto.ValidationRequestDTO;
import com.fnd.games_store.login.controller.dto.ValidationResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;

public interface UserValidation {

//    public ResponseEntity<ValidationResponseDTO> validateUser(HttpServletRequest request);
    public Boolean validateUser(ValidationRequestDTO validationRequestDTO);


}
