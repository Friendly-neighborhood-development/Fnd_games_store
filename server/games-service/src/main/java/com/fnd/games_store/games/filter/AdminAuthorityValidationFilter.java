package com.fnd.games_store.games.filter;


import com.fnd.games_store.games.rest.AuthorityValidationClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Slf4j
public class AdminAuthorityValidationFilter extends OncePerRequestFilter {


//    @Autowired
//    private AuthorityValidationClient authorityValidationClient;

    public AdminAuthorityValidationFilter() {
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {


//        authorityValidationClient.validateUserWithAuthority(request.getHeader("authorization"));

        log.info(request.getHeader("authorization"));

        filterChain.doFilter(request,response);

    }
}
