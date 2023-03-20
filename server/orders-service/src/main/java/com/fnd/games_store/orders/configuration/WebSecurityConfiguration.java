package com.fnd.games_store.orders.configuration;



import com.fnd.games_store.orders.filter.ActuatorFilter;
import com.fnd.games_store.orders.filter.JwtFilter;
import com.fnd.games_store.orders.rest.UserValidationClient;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

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

    @Bean(name = "actuatorFilter")
    public ActuatorFilter actuatorFilter(){
        return new ActuatorFilter();
    }

    @Bean
    public FilterRegistrationBean actuatorFilterRegistration() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(actuatorFilter());
        registration.addUrlPatterns("/actuator/**");
        registration.setName("actuatorFilter");
        return registration;
    }

    @Bean(name = "globalFilter")
    public JwtFilter globalFilter(){
        return new JwtFilter();
    }
    @Bean
    public FilterRegistrationBean globalFilterRegistration() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(globalFilter());
        registration.addUrlPatterns("/v1/purchases/**");
        registration.setName("globalFilter");
        return registration;
    }

}
