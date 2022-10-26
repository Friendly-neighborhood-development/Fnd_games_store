package com.fnd.games_store.cart.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {


    @Bean
    public SecurityFilterChain filter(HttpSecurity http) throws Exception {

        http.authorizeRequests().antMatchers("/v1/update").permitAll().anyRequest().authenticated();

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);

        http.formLogin().disable();

        http.cors().disable();

        http.csrf().disable().headers().disable();

        return http.build();

    }

}
