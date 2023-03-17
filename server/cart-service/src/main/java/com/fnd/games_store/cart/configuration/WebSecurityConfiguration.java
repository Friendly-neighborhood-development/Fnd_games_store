package com.fnd.games_store.cart.configuration;

import com.fnd.games_store.cart.filter.JwtFilter;
import com.fnd.games_store.cart.rest.UserValidationClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class WebSecurityConfiguration {

    @Bean
    public SecurityFilterChain filter(HttpSecurity http) throws Exception {

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);

        http.formLogin().disable();

        http.cors().disable();

        http.csrf().disable();

        return http.build();

    }

    @Bean
    public JwtFilter globalFilter(UserValidationClient userValidationClient){
        return new JwtFilter(userValidationClient);
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers( "/actuator/health");
    }

}
