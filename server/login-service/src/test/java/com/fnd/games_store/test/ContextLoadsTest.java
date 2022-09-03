package com.fnd.games_store.test;


import com.fnd.games_store.login.LoginApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;

@SpringBootTest(classes = LoginApplication.class)
public class ContextLoadsTest {

    @Autowired
    ApplicationContext context;



    @Test
    void loads(){
        assertThat(context.getAutowireCapableBeanFactory()).isNotNull();
    }


}
