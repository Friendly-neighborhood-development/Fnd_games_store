package com.fnd.games_store.test.jwt_utils;

import com.fnd.games_store.login.LoginApplication;
import com.fnd.games_store.login.jwt_utils.JwtGenerator;
import com.fnd.games_store.login.jwt_utils.JwtValidator;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = LoginApplication.class)
public class ValidateJwtToken_UnitTest {


    @Autowired
    private JwtGenerator jwtGenerator;

    @Autowired
    private JwtValidator jwtValidator;


    private String referenceToken;


    @BeforeEach
    void testSetup(){
        referenceToken = jwtGenerator.generateJwtToken(generateUserDetails("admin"));
    }

    private UserDetails generateUserDetails(String username){

        List<GrantedAuthority> adminGrantedAuthorities = new ArrayList<>();

        return new User(username,
                "",
                true,
                true,
                true,
                true,
                adminGrantedAuthorities);
    }




}
