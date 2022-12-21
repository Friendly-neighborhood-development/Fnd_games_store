package com.fnd.games_store.login.controller;

import com.fnd.games_store.login.dto.ValidationResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Map;

public interface UserValidation {


    ResponseEntity<ValidationResponseDTO> validateUser(@RequestHeader Map<String, String> headers);
}
