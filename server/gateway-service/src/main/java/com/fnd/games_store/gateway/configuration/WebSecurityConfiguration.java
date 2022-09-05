package com.fnd.games_store.gateway.configuration;


import com.fnd.games_store.gateway.jwt_utils.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;


//@Configuration
public class WebSecurityConfiguration {


    @Autowired
    private JwtFilter jwtFilter;

////    @Bean
//    public SecurityFilterChain filter(HttpSecurity http) throws Exception {
//
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
//
//        return http.build();
//    }
//
////    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }

}
