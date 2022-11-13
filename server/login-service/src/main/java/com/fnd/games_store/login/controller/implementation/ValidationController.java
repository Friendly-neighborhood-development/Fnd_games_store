package com.fnd.games_store.login.controller.implementation;

import com.fnd.games_store.login.controller.UserValidation;
import com.fnd.games_store.login.dto.ValidationResponseDTO;
import com.fnd.games_store.login.service.ValidationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@CrossOrigin
public class ValidationController implements UserValidation {


    private final ValidationService validationService;

    @Autowired
    public ValidationController(ValidationService validationService) {
        this.validationService = validationService;
    }

    @Override
    @PostMapping("/v1/validate")
    public ResponseEntity<ValidationResponseDTO> validateUser(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {
        Boolean isIncomingTokenValid = validationService.validate(authHeader);
        return ResponseEntity.ok(new ValidationResponseDTO(isIncomingTokenValid));
    }

}
