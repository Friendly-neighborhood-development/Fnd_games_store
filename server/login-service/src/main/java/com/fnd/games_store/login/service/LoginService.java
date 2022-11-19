package com.fnd.games_store.login.service;

import com.fnd.games_store.login.dto.LoginResponseDTO;
import com.fnd.games_store.login.entity.Authority;

import java.util.List;

public interface LoginService {

    public LoginResponseDTO login(String username, String password);

}
