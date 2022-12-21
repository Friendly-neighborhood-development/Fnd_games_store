package com.fnd.games_store.login.controller.implementation;

import com.fnd.games_store.login.controller.UserValidation;
import com.fnd.games_store.login.dto.ValidationResponseDTO;
import com.fnd.games_store.login.service.ValidationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Slf4j
public class ValidationController implements UserValidation{


    private final ValidationService validationService;

    @Autowired
    public ValidationController(ValidationService validationService) {
        this.validationService = validationService;
    }

    @Override
    @PostMapping(path = "/v1/validate")
    public ResponseEntity<ValidationResponseDTO> validateUser(@RequestHeader Map<String, String> headers) {

        printHeadersToConsole(headers);

        String incomingUserToken = headers.get("authorization");
        log.info(incomingUserToken);


        Boolean isIncomingTokenValid = validationService.validate(incomingUserToken);

        return ResponseEntity.ok(new ValidationResponseDTO(isIncomingTokenValid));
    }


    @Profile("test")
    private void printHeadersToConsole(Map<String, String> headers){
        headers.entrySet().stream().forEach(System.out::println);
    }




}

