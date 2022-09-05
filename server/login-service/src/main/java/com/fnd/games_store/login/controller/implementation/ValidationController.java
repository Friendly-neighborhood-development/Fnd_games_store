package com.fnd.games_store.login.controller.implementation;

import com.fnd.games_store.login.controller.UserValidation;
import com.fnd.games_store.login.controller.dto.ValidationRequestDTO;
import com.fnd.games_store.login.controller.dto.ValidationResponseDTO;
import com.fnd.games_store.login.service.ValidationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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
    @PostMapping("/validate")
    public Boolean validateUser(@RequestBody ValidationRequestDTO validationRequestDTO) {


        log.info("I WAS ACCESSED !!!!!!!");

        log.info("incoming token: "+ validationRequestDTO.getToken());

        Boolean isIncomingTokenValid = validationService.validate(validationRequestDTO.getToken());

        log.info(isIncomingTokenValid.toString());

        return isIncomingTokenValid;
    }


}
