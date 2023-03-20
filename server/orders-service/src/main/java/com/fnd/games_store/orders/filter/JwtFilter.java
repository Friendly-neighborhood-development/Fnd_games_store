package com.fnd.games_store.orders.filter;

import com.fnd.games_store.orders.exception.UserValidationFailedException;
import com.fnd.games_store.orders.rest.UserValidationClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private UserValidationClient userValidator;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = request.getHeader("authorization");

        Boolean isUserValid = userValidator.validateUser(token).getBody().getIsTokenValid();

        if (isUserValid){
            filterChain.doFilter(request, response);
        } else throw new UserValidationFailedException("Failed to validate user");


    }
}
