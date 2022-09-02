package com.fnd.games_store.login.controller.implementation;


import com.fnd.games_store.login.controller.LoginController;
import com.fnd.games_store.login.controller.dto.LoginRequestDTO;
import com.fnd.games_store.login.controller.dto.LoginResponseDTO;
import com.fnd.games_store.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;


public class LoginControllerImpl implements LoginController {


    @Autowired
    LoginService loginService;

    @Override
    @GetMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) {

        String generatedToken = loginService.login(loginRequestDTO.getUsername(), loginRequestDTO.getPassword());

        return ResponseEntity.ok(new LoginResponseDTO(generatedToken));
    }





}
