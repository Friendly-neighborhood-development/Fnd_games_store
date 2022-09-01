package com.fnd.games_store.test.jwt_utils;

import com.fnd.games_store.login.LoginApplication;
import com.fnd.games_store.login.jwt_utils.JwtGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Field;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = LoginApplication.class)
public class JwtGeneratorTest {

    @Autowired
    JwtGenerator JwtGeneratorImpl;

    @Test
    void doesTheFieldInjects(){
        Field[] fields = JwtGeneratorImpl.getClass().getDeclaredFields();
        for(Field field: fields){
            assertThat(field).isNotNull();
        }


    }

}
