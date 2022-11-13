package com.fnd.games_store.login.controller;

import com.fnd.games_store.login.dto.LoginRequestDTO;
import com.fnd.games_store.login.dto.LoginResponseDTO;
import org.springframework.http.ResponseEntity;

public interface UserLogin {

    public ResponseEntity<LoginResponseDTO> login(LoginRequestDTO loginRequestDTO);

}
