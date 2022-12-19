package com.fnd.games_store.test.service;

import com.fnd.games_store.login.dto.LoginResponseDTO;
import com.fnd.games_store.login.entity.Account;
import com.fnd.games_store.login.entity.Authority;
import com.fnd.games_store.login.jwt_utils.JwtGenerator;
import com.fnd.games_store.login.repository.AccountRepository;
import com.fnd.games_store.login.service.LoginService;
import com.fnd.games_store.login.service.implementation.LoginServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static org.assertj.core.api.Assertions.*;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Login_UnitTest {

    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private UserDetailsService userDetails;
    @Mock
    private JwtGenerator jwtGenerator;
    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private LoginServiceImpl loginService;

    private String username = "admin";

    private String password = "password";

    private LocalDate date = LocalDate.parse("2030-01-01");

    private String generatedToken = "token";



    @Test
    void login_shouldReturnValidResponse(){
        assertThat(loginService.login(username, password)).isEqualTo(createAppropriateResponse());
        verify(passwordEncoder).matches(password, userDetails.loadUserByUsername(username).getPassword());
    }



    @BeforeEach
    void testSetup(){

        when(userDetails.loadUserByUsername(username)).thenReturn(createProperAdminUserInstance());
        when(accountRepository.findAccountByUsername(username)).thenReturn(createAppropriateAccount());
        when(jwtGenerator.generateJwtToken(createProperAdminUserInstance())).thenReturn(generatedToken);

    }


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
                password,
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
        creatingAccount.setPassword(password);
        creatingAccount.setIsAccountEnabled(true);
        creatingAccount.setExpirationDate(date);
        creatingAccount.setCredentialsExpirationDate(date);
        creatingAccount.setIsAccountNonLocked(true);
        creatingAccount.setAuthorities(adminGrantedAuthorities);

        return Optional.of(creatingAccount);
    }


    private LoginResponseDTO createAppropriateResponse(){
        return new LoginResponseDTO("1", generatedToken);
    }


}
