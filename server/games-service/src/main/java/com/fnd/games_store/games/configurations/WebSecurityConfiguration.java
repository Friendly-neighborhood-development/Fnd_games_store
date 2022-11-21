package com.fnd.games_store.games.configurations;

import com.fnd.games_store.games.filter.AuthorityValidationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class WebSecurityConfiguration {


    private final AuthorityValidationFilter authorityValidationFilter;
    @Autowired
    public WebSecurityConfiguration(AuthorityValidationFilter authorityValidationFilter) {
        this.authorityValidationFilter = authorityValidationFilter;
    }


    @Bean
    public SecurityFilterChain filter(HttpSecurity http) throws Exception {

        http.authorizeRequests().antMatchers("/v1/catalogue/all", "/h2/**").permitAll().anyRequest().authenticated();

        http.addFilterBefore(authorityValidationFilter, UsernamePasswordAuthenticationFilter.class);

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);

        http.formLogin().disable();

        http.cors().disable();

        http.csrf().disable();

        return http.build();

    }




}
