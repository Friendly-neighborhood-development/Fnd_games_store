package com.fnd.games_store.cart.test.filter;

import com.fnd.games_store.cart.filter.JwtFilter;
import com.fnd.games_store.cart.rest.UserValidationClient;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class TestJwtFilter extends JwtFilter {


    public TestJwtFilter(UserValidationClient userValidator) {
        super(userValidator);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        filterChain.doFilter(request,response);
        log.info(("===== test_request_filtered====="));

    }



}
