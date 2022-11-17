package com.fnd.games_store.cart.filter;

import com.fnd.games_store.cart.dto.ValidationResponseDTO;
import com.fnd.games_store.cart.exception.UserValidationFailedException;
import com.fnd.games_store.cart.rest.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {


    private final UserValidator userValidator;

    @Autowired
    public JwtFilter(UserValidator userValidator) {
        this.userValidator = userValidator;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = request.getHeader("Authorization").substring(7);

        ValidationResponseDTO validationResult = userValidator.validateUser(token).getBody();

        if (validationResult.getIsTokenValid()){
            filterChain.doFilter(request, response);
        } else throw new UserValidationFailedException("Failed to validate user");




    }
}
