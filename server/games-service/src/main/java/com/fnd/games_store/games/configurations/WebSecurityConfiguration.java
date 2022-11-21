package com.fnd.games_store.games.configurations;

import com.fnd.games_store.games.filter.AdminAuthorityValidationFilter;
import com.fnd.games_store.games.filter.StaffAuthorityValidationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class WebSecurityConfiguration {


    private final AdminAuthorityValidationFilter adminAuthorityValidationFilter;

    private final StaffAuthorityValidationFilter staffAuthorityValidationFilter;

    @Autowired
    public WebSecurityConfiguration(AdminAuthorityValidationFilter adminAuthorityValidationFilter, StaffAuthorityValidationFilter staffAuthorityValidationFilter) {
        this.adminAuthorityValidationFilter = adminAuthorityValidationFilter;
        this.staffAuthorityValidationFilter = staffAuthorityValidationFilter;
    }

    @Bean
    public SecurityFilterChain filter(HttpSecurity http) throws Exception {

        http.authorizeRequests().antMatchers("/v1/catalogue/all", "/v1/catalogue/**").permitAll().anyRequest().authenticated().and()
                .addFilterBefore(adminAuthorityValidationFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(staffAuthorityValidationFilter, UsernamePasswordAuthenticationFilter.class);





        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);

        http.formLogin().disable();

        http.cors().disable();

        http.csrf().disable();

        return http.build();

    }




}
