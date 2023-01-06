package com.fnd.games_store.login.service.implementation;


import com.fnd.games_store.login.dto.AccountRequestDTO;
import com.fnd.games_store.login.dto.AccountResponseDTO;
import com.fnd.games_store.login.entity.Account;
import com.fnd.games_store.login.repository.AccountRepository;
import com.fnd.games_store.login.service.AccountRegistration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import java.time.LocalDate;

@Service
@Slf4j
public class AccountRegistrationImpl implements AccountRegistration {

    @Value("${variables.common.new_account_expiration_date}")
    private String expirationDate;

    private final AccountRepository repository;

    private final PasswordEncoder encoder;

    @Autowired
    public AccountRegistrationImpl(AccountRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @Override
    public AccountResponseDTO register(AccountRequestDTO accountRequestDTO) {

        Account newAccount = new Account();

        newAccount.setUsername(accountRequestDTO.getUsername());
        newAccount.setPassword(encoder.encode(accountRequestDTO.getPassword()));
        newAccount.setEmail(accountRequestDTO.getEmail());
        newAccount.setExpirationDate(LocalDate.parse(expirationDate));

//        @Column(name = "expiration_date")
//        private LocalDate expirationDate;
//        @Column(name = "is_account_non_locked")
//        private Boolean isAccountNonLocked;
//        @Column(name = "credentials_expiration_date")
//        private LocalDate credentialsExpirationDate;
//        @Column(name ="is_account_enabled")
//        private Boolean isAccountEnabled;



        repository.save(newAccount);

        return new AccountResponseDTO(newAccount.getId(), newAccount.getUsername());
    }
}
