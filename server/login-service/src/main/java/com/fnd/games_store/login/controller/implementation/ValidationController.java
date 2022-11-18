package com.fnd.games_store.login.controller.implementation;

import com.fnd.games_store.login.controller.UserValidation;
import com.fnd.games_store.login.dto.ValidationResponseDTO;
import com.fnd.games_store.login.service.ValidationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@Slf4j
@CrossOrigin
public class ValidationController {


    private final ValidationService validationService;

    @Autowired
    public ValidationController(ValidationService validationService) {
        this.validationService = validationService;
    }

//    @Override
    @PostMapping("/v1/validate")
    public ResponseEntity<ValidationResponseDTO> validateUser(@RequestHeader Map<String,String> headers) {

        headers.entrySet().stream().forEach(System.out::println);
        log.info(headers.get("authorization"));
        Boolean isIncomingTokenValid = validationService.validate(headers.get("authorization"));
        log.info(headers.get(isIncomingTokenValid));
        return ResponseEntity.ok(new ValidationResponseDTO(isIncomingTokenValid));
    }

}
