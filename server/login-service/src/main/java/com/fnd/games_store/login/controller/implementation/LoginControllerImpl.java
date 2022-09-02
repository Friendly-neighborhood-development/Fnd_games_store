package com.fnd.games_store.login.controller.implementation;


import com.fnd.games_store.login.controller.LoginController;
import com.fnd.games_store.login.controller.dto.LoginRequestDTO;
import com.fnd.games_store.login.controller.dto.LoginResponseDTO;
import com.fnd.games_store.login.service.implementation.LoginServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@Slf4j
public class LoginControllerImpl implements LoginController {


    @Autowired
    LoginServiceImpl loginService;

    @Override
    @GetMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        log.info(loginRequestDTO.getUsername());
        log.info(loginRequestDTO.getPassword());

        String generatedToken = loginService.login(loginRequestDTO.getUsername(), loginRequestDTO.getPassword());

        return ResponseEntity.ok(new LoginResponseDTO(generatedToken));
    }





}
