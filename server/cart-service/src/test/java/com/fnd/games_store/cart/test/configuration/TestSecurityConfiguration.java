package com.fnd.games_store.cart.test.configuration;


import com.fnd.games_store.cart.rest.UserValidationClient;
import com.fnd.games_store.cart.test.filter.TestJwtFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
//@Profile("test")
public class TestSecurityConfiguration {

    @Bean
    public TestJwtFilter testGlobalFilter(UserValidationClient userValidator){
        return new TestJwtFilter(userValidator);
    }

}
