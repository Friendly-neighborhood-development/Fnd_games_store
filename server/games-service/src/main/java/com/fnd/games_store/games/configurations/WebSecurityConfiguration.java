package com.fnd.games_store.games.configurations;

import com.fnd.games_store.games.filter.ActuatorFilter;
import com.fnd.games_store.games.filter.AdminAuthorityValidationFilter;
import com.fnd.games_store.games.filter.StaffAuthorityValidationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfiguration {


    @Bean(name = "adminAuthorityValidationFilter")
    public AdminAuthorityValidationFilter adminAuthorityValidationFilter() {
        return new AdminAuthorityValidationFilter();
    }


    @Bean(name = "staffAuthorityValidationFilter")
    public StaffAuthorityValidationFilter staffAuthorityValidationFilter(){
        return new StaffAuthorityValidationFilter();
    }

    @Bean
    public FilterRegistrationBean staffAuthorityValidationFilterRegistration() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(staffAuthorityValidationFilter());
        registration.addUrlPatterns("/v1/catalogue/new","/v1/catalogue/updating/*");
        registration.setName("staffAuthorityValidationFilter");
        return registration;
    }


    @Bean
    public FilterRegistrationBean adminAuthorityValidationFilterRegistration() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(adminAuthorityValidationFilter());
        registration.addUrlPatterns("/v1/catalogue/deleting/*");
        registration.setName("adminAuthorityValidationFilter");
        return registration;
    }


    @Bean
    public SecurityFilterChain securitySettings(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests().antMatchers("/v1/catalogue/*", "v1/catalogue/list/*", "/actuator/**").permitAll().anyRequest().authenticated();

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);

        http.formLogin().disable();

        http.cors().disable();

        http.csrf().disable();

        return http.build();

    }

    @Bean
    @Profile("standalone")
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers( "/h2/*");
    }


}
