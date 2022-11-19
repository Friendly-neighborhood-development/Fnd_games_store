package com.fnd.games_store.login.controller.implementation;


import com.fnd.games_store.login.controller.UserLogin;
import com.fnd.games_store.login.dto.LoginRequestDTO;
import com.fnd.games_store.login.dto.LoginResponseDTO;

import com.fnd.games_store.login.entity.Account;
import com.fnd.games_store.login.repository.AccountRepository;
import com.fnd.games_store.login.service.LoginService;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@Slf4j
public class LoginController implements UserLogin {


    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @Override
    @PostMapping("/v1/authorization")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        return ResponseEntity.ok(loginService.login(loginRequestDTO.getUsername(), loginRequestDTO.getPassword()));
    }

}
