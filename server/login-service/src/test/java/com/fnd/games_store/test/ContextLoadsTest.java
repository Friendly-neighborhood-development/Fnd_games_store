package com.fnd.games_store.test;


import com.fnd.games_store.login.LoginApplication;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

@SpringBootTest(classes = LoginApplication.class)
public class ContextLoadsTest {





    @Test
    void loads(){
        assertThat("").isNotNull();
    }


}
