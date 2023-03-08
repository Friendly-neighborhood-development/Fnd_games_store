package com.fnd.games_store.test.service;

import com.fnd.games_store.login.LoginApplication;
import com.fnd.games_store.login.dto.LoginResponseDTO;
import com.fnd.games_store.login.entity.Account;
import com.fnd.games_store.login.entity.Authority;
import com.fnd.games_store.login.exception.InvalidPasswordException;
import com.fnd.games_store.login.service.implementation.LoginServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest(classes = LoginApplication.class)
public class LoginServiceTest {


    @Autowired
    private LoginServiceImpl loginService;

    private String username = "admin";

    private String wrongPassword = "password1";

    private LocalDate date = LocalDate.parse("2030-01-01");

    private String generatedToken = "token";

    private LoginResponseDTO expectedLoginResponse;

    @Test
    void login_shouldReturnValidResponse(){

        InvalidPasswordException thrownException = assertThrows(InvalidPasswordException.class, ()-> loginService.login(username, wrongPassword));
    }



    @BeforeEach
    void testSetup(){
        expectedLoginResponse = createAppropriateResponse();
    }

    //TODO refactor this with stream later
    private User createProperAdminUserInstance(){

        List<GrantedAuthority> adminGrantedAuthorities = new ArrayList<>();

//        Authority adminAuthority = new Authority("1", "super_user");
//        Authority staffAuthority = new Authority("2", "staff_user");
//        Authority regularAuthority = new Authority("3", "regular_user");
//
//
//        adminGrantedAuthorities.add(adminAuthority);
//        adminGrantedAuthorities.add(staffAuthority);
//        adminGrantedAuthorities.add(regularAuthority);

        return new User(username,
                wrongPassword,
                true,
                true,
                true,
                true,
                adminGrantedAuthorities);
    }


    private Optional<Account> createAppropriateAccount(){

        Account creatingAccount = new Account();
        List<Authority> adminGrantedAuthorities = new ArrayList<>();

        creatingAccount.setId("1");
        creatingAccount.setUsername(username);
        creatingAccount.setPassword(wrongPassword);
        creatingAccount.setIsAccountEnabled(true);
        creatingAccount.setExpirationDate(date);
        creatingAccount.setCredentialsExpirationDate(date);
        creatingAccount.setIsAccountNonLocked(true);
        creatingAccount.setAuthority(adminGrantedAuthorities);

        return Optional.of(creatingAccount);
    }

    private LoginResponseDTO createAppropriateResponse(){
        return new LoginResponseDTO("1", generatedToken);
    }


}
