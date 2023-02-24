package com.fnd.games_store.orders.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class MiscellaneousTestConfiguration {


    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }

}
