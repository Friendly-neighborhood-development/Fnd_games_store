package com.fnd.games_store.login.controller.implementation;


import com.fnd.games_store.login.controller.Login;
import com.fnd.games_store.login.controller.dto.LoginRequestDTO;
import com.fnd.games_store.login.controller.dto.LoginResponseDTO;
import com.fnd.games_store.login.service.LoginService;
import com.fnd.games_store.login.service.implementation.LoginServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin
@Slf4j
public class LoginController implements Login {


    @Autowired
    LoginService loginService;

    @Override
    @GetMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO, HttpSession session) {
        String generatedToken = loginService.login(loginRequestDTO.getUsername(), loginRequestDTO.getPassword());

        log.info(session.getId());

        return ResponseEntity.ok(new LoginResponseDTO(generatedToken));
    }





}
