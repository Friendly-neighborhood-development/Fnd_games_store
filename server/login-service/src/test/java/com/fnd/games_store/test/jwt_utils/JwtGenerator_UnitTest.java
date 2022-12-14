package com.fnd.games_store.test.jwt_utils;

import com.fnd.games_store.login.LoginApplication;
import com.fnd.games_store.login.jwt_utils.implementation.JwtGeneratorImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = LoginApplication.class)
@Slf4j
public class JwtGenerator_UnitTest {

    @Autowired
    JwtGeneratorImpl jwtGeneratorImpl;

    private String injectedSecret;

    private Long injectedExpiration;


    @Test
    void doesInjectedFieldsHaveCorrectValues() {
        assertThat(injectedSecret).isEqualTo("OTFBRjg3MUMwOUYxODlFNDc3NEQwNTAxMTg0M0M0NzI5QTczNDY1QUU4MTA5MUFERjZFNDIxNTk0QTZDOUYyQg==");
        assertThat(injectedExpiration).isEqualTo(90000000);
    }

    @BeforeEach
    private void injectedFiledValuesAccessSetUp() {
        injectedSecret = jwtGeneratorImpl.getJwtAccessSecret();
        injectedExpiration = jwtGeneratorImpl.getAccessTokenExpirationDuration();

    }


}
