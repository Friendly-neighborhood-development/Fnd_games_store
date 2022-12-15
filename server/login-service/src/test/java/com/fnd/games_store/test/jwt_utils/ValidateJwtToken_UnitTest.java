package com.fnd.games_store.test.jwt_utils;

import com.fnd.games_store.login.LoginApplication;
import com.fnd.games_store.login.jwt_utils.JwtGenerator;
import com.fnd.games_store.login.jwt_utils.JwtValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = LoginApplication.class)
public class ValidateJwtToken_UnitTest {


    @Autowired
    private JwtGenerator jwtGenerator;

    @Autowired
    private JwtValidator jwtValidator;


    private String referenceToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTY3MTEyMzU1MywiaWF0IjoxNjcxMDMzNTUzfQ._IDSuEOf6ie6ds9qHqwuBOEVRyikEp3fJ9hn6rUiQhs";



}
