package com.fnd.games_store.cart.filter;

import com.fnd.games_store.cart.exception.UserValidationFailedException;
import com.fnd.games_store.cart.rest.UserValidationClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@Slf4j
public class JwtFilter extends OncePerRequestFilter {


    private final UserValidationClient userValidator;

    @Autowired
    public JwtFilter(UserValidationClient userValidator) {
        this.userValidator = userValidator;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = request.getHeader("authorization");

        Boolean isUserValid = userValidator.validateUser(token).getBody().getIsTokenValid();

        if (isUserValid){
            filterChain.doFilter(request, response);
        } else throw new UserValidationFailedException("Failed to validate user");


    }
}
