package com.fnd.games_store.test.jwt_utils;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fnd.games_store.login.LoginApplication;
import com.fnd.games_store.login.jwt_utils.JwtGenerator;
import com.fnd.games_store.login.jwt_utils.JwtValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest(classes = LoginApplication.class)
public class ValidateJwtToken_UnitTest {


    @Autowired
    private JwtGenerator jwtGenerator;

    @Autowired
    private JwtValidator jwtValidator;

    private String referenceToken;

    private String expiredToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdGFmZiIsImF1dGhzIjpudWxsLCJleHAiOjE2NzA4MzU1NjAsImlhdCI6MTY3MDc0NTU2MH0.UsnoIHZ0Pkdl8Wp48W12ydNzAGEWMOWpbX6DOeCKXQI";


    @Test
    void validateJwtToken_ShouldValidateProperToken(){
        assertThat(jwtValidator.validateJwtToken(referenceToken)).isTrue();
    }


    @Test
    void validateJwtToken_ShouldNotValidateExpiredToken(){
        assertThrows(TokenExpiredException.class, ()->{
            jwtValidator.validateJwtToken(expiredToken);
        });
    }


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
