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

        http.authorizeRequests().antMatchers("/addItem").permitAll().anyRequest().authenticated();

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);

        http.formLogin().disable();

        return http.build();

    }

//    @Bean
//    public AuthenticationManager authenticationManager() throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }

//    @Bean
//    public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }

}
