package com.fnd.games_store.login.controller;

import com.fnd.games_store.login.controller.dto.LoginRequestDTO;
import com.fnd.games_store.login.controller.dto.LoginResponseDTO;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpSession;

public interface LoginController {

    public ResponseEntity<LoginResponseDTO> login(LoginRequestDTO loginRequestDTO, HttpSession session);

}
