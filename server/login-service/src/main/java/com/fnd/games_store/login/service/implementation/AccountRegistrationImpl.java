package com.fnd.games_store.login.service.implementation;


import com.fnd.games_store.login.dto.AccountRequestDTO;
import com.fnd.games_store.login.dto.AccountResponseDTO;
import com.fnd.games_store.login.repository.AccountRepository;
import com.fnd.games_store.login.service.AccountRegistration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AccountRegistrationImpl implements AccountRegistration {


    private AccountRepository repository;

    @Autowired
    public AccountRegistrationImpl(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public AccountResponseDTO register(AccountRequestDTO accountRequestDTO) {
        return null;
    }
}
