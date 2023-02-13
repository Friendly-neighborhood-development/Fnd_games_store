package com.fnd.games_store.orders.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MiscellaneousConfiguration {



    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }


}
