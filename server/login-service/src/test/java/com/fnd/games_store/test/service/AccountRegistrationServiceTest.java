package com.fnd.games_store.test.service;


import com.fnd.games_store.login.LoginApplication;
import com.fnd.games_store.login.dto.AccountRequestDTO;
import com.fnd.games_store.login.entity.Account;
import com.fnd.games_store.login.entity.Authority;
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
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest(classes = LoginApplication.class)
@Slf4j
@Transactional
public class AccountRegistrationServiceTest {


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

    private List<Authority> accountAuthoritiesList = new ArrayList<>();


    @Test
    void register_ShouldSaveNewAccountEntityToDB(){

        assertThat(loadedAccountEntityFromDB).isEqualTo(expectedAccountEntity);

    }

    @BeforeEach
    void testSetup() {

        newAccountData = createAppropriateNewAccountDTO(username,password,email);

        service.register(newAccountData);

        loadedAccountEntityFromDB = repository.findAccountByUsername(username).get();
        loadedAccountEntityFromDB.setId(null);
        loadedAccountEntityFromDB.setPassword(password);

        expectedAccountEntity = creteAppropriateAccountEntity(username,password,email);

    }


    public Account creteAppropriateAccountEntity(String username, String password, String email) {

        Account newAccount = new Account();
        Authority regularUserAuthority = authorityRepository.findById("3").get();

        newAccount.setId(null);
        newAccount.setUsername(username);
        newAccount.setPassword(password);
        newAccount.setEmail(email);
        newAccount.setExpirationDate(LocalDate.parse(expirationDate));
        newAccount.setIsAccountNonLocked(true);
        newAccount.setCredentialsExpirationDate(LocalDate.parse(expirationDate));
        newAccount.setIsAccountEnabled(true);

        accountAuthoritiesList.add(regularUserAuthority);
        newAccount.setAuthority(accountAuthoritiesList);


        return newAccount;
    }



    private AccountRequestDTO createAppropriateNewAccountDTO(String username, String password, String email){
        AccountRequestDTO savingAccount = new AccountRequestDTO(username,password,email);
        return savingAccount;
    }


}
