package com.fnd.games_store.login.service;

import com.fnd.games_store.login.dto.AccountRequestDTO;
import com.fnd.games_store.login.dto.AccountResponseDTO;

public interface AccountRegistrationService {
    AccountResponseDTO register(AccountRequestDTO accountRequestDTO);
}
