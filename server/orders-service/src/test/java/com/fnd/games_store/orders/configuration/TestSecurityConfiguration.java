package com.fnd.games_store.orders.configuration;



import com.fnd.games_store.orders.filter.TestJwtFilter;
import com.fnd.games_store.orders.rest.UserValidationClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestSecurityConfiguration {

    @Bean
    public TestJwtFilter testGlobalFilter(){
        return new TestJwtFilter();
    }

}
