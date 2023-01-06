package com.fnd.games_store.test.service;


import com.fnd.games_store.login.LoginApplication;
import com.fnd.games_store.login.dto.AccountRequestDTO;
import com.fnd.games_store.login.entity.Account;
import com.fnd.games_store.login.repository.AccountRepository;
import com.fnd.games_store.login.service.AccountRegistration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTestContextBootstrapper;
import org.springframework.test.context.BootstrapWith;

@DataJpaTest
@BootstrapWith(SpringBootTestContextBootstrapper.class)
@SpringBootTest(classes = LoginApplication.class)
public class RegisterNewAccount{


    @Autowired
    private AccountRepository repository;

    @Autowired
    private AccountRegistration service;

    private String username = "Alfonso";

    private String password = "original_password_123";

    private String email = "alfonso@email.com";

    private AccountRequestDTO newAccountData;

    private Account loadedAccountEntityFromDB;

    private Account expectedAccountEntity;


    @Test
    void register_ShouldSaveNewAccountEntityToDB(){

    }



    private AccountRequestDTO createAppropriateNewAccountDTO(String username, String password, String email){
        AccountRequestDTO savingAccount = new AccountRequestDTO(username,password,email);
        return savingAccount;
    }

    @BeforeEach
    void testSetup(){
        newAccountData = createAppropriateNewAccountDTO(username,password,email);

        service.register(newAccountData);

    }




}
