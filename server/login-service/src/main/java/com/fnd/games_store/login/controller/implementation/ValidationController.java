package com.fnd.games_store.login.controller.implementation;

import com.fnd.games_store.login.controller.UserValidation;
import com.fnd.games_store.login.controller.dto.ValidationResponseDTO;
import com.fnd.games_store.login.service.ValidationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("/validate")
    public ResponseEntity<ValidationResponseDTO> validateUser(HttpServletRequest request) {

        String incomingToken = request.getHeader("Authorization").substring(7);

        log.info("incoming token: "+ incomingToken);

        Boolean isIncomingTokenValid = validationService.validate(incomingToken);

        return ResponseEntity.ok(new ValidationResponseDTO(isIncomingTokenValid));
    }
}
