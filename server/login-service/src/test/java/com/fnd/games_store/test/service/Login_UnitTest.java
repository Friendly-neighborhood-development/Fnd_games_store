package com.fnd.games_store.test.service;

import com.fnd.games_store.login.jwt_utils.JwtGenerator;
import com.fnd.games_store.login.service.LoginService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;

@ExtendWith(MockitoExtension.class)
public class Login_UnitTest {

    @Mock
    private AuthenticationManager authenticationManager;
    @Mock
    private UserDetailsService userDetails;
    @Mock
    private JwtGenerator jwtGenerator;

    @InjectMocks
    private LoginService loginService;


    @Test
    void login_shouldReturnValidResponse(){

    }



    @BeforeEach
    void testSetup(){






    }





}
