package com.fnd.games_store.login.controller.implementation;


import com.fnd.games_store.login.controller.UserRegistration;
import com.fnd.games_store.login.dto.AccountRequestDTO;
import com.fnd.games_store.login.dto.AccountResponseDTO;
import com.fnd.games_store.login.service.AccountRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController implements UserRegistration {


    private final AccountRegistration service;

    @Autowired
    public RegistrationController(AccountRegistration service) {
        this.service = service;
    }

    @Override
    @PostMapping("/v1/registration")
    public ResponseEntity<AccountResponseDTO> registerNewUser(@RequestBody AccountRequestDTO accountRequestDTO) {
        return ResponseEntity.ok(service.register(accountRequestDTO));
    }
}
