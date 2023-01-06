package com.fnd.games_store.test.service;


import com.fnd.games_store.login.LoginApplication;
import com.fnd.games_store.login.dto.AccountRequestDTO;
import com.fnd.games_store.login.entity.Account;
import com.fnd.games_store.login.repository.AccountRepository;
import com.fnd.games_store.login.repository.AuthorityRepository;
import com.fnd.games_store.login.service.AccountRegistration;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.Objects;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest(classes = LoginApplication.class)
@Slf4j
public class RegisterNewAccount{


    @Autowired
    private AccountRepository repository;

    @Autowired
    private AccountRegistration service;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Value("${variables.common.new_account_expiration_date}")
    private String expirationDate;

    private String username = "Alfonso";

    private String password = "original_password_123";

    private String email = "alfonso@email.com";

    private AccountRequestDTO newAccountData;

    private Account loadedAccountEntityFromDB;

    private Account expectedAccountEntity;


    @Test
    void register_ShouldSaveNewAccountEntityToDB(){
////        Boolean areEntitiesEqual = loadedAccountEntityFromDB.equals(expectedAccountEntity);
//
//        Boolean areEntitiesEqual = Objects.equals(loadedAccountEntityFromDB, expectedAccountEntity);
//
//        assertThat(areEntitiesEqual).isTrue();

//        assertThat(loadedAccountEntityFromDB).isEqualTo(expectedAccountEntity);

        log.info("test "+authorityRepository.findById("3").get());

    }

    @BeforeEach
    void testSetup() {

        newAccountData = createAppropriateNewAccountDTO(username,password,email);

        service.register(newAccountData);

//        loadedAccountEntityFromDB = repository.findAccountByUsername(username).get();

        expectedAccountEntity = creteAppropriateAccountEntity(username,password,email);

    }


    public Account creteAppropriateAccountEntity(String username, String password, String email) {

        Account newAccount = new Account();

        newAccount.setUsername(username);
        newAccount.setPassword(encoder.encode(password));
        newAccount.setEmail(email);
        newAccount.setExpirationDate(LocalDate.parse(expirationDate));
        newAccount.setIsAccountNonLocked(true);
        newAccount.setCredentialsExpirationDate(LocalDate.parse(expirationDate));
        newAccount.setIsAccountEnabled(true);

        return newAccount;
    }



    private AccountRequestDTO createAppropriateNewAccountDTO(String username, String password, String email){
        AccountRequestDTO savingAccount = new AccountRequestDTO(username,password,email);
        return savingAccount;
    }


}
