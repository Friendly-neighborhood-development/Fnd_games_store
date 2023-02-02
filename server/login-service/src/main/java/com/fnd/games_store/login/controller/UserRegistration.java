package com.fnd.games_store.login.controller;


import com.fnd.games_store.login.dto.AccountRequestDTO;
import com.fnd.games_store.login.dto.AccountResponseDTO;
import org.springframework.http.ResponseEntity;

public interface UserRegistration {

    ResponseEntity<AccountResponseDTO> registerNewUser(AccountRequestDTO accountRequestDTO);

}
