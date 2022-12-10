package com.fnd.games_store.cart.test.configuration;


import com.fnd.games_store.cart.rest.UserValidationClient;
import com.fnd.games_store.cart.test.TestJwtFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfiguration {

    @Bean
    public TestJwtFilter globalFilter(UserValidationClient userValidator){
        return new TestJwtFilter(userValidator);
    }

}
