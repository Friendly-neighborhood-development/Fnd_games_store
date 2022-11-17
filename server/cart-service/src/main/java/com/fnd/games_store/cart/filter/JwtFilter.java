package com.fnd.games_store.cart.filter;

import com.fnd.games_store.cart.dto.ValidationResponseDTO;
import com.fnd.games_store.cart.exception.UserValidationFailedException;
import com.fnd.games_store.cart.rest.UserValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class JwtFilter extends OncePerRequestFilter {


    private final UserValidator userValidator;

    @Autowired
    public JwtFilter(UserValidator userValidator) {
        this.userValidator = userValidator;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        Map<String,String> headers = new HashMap<>();

        String token = request.getHeader("Authorization").substring(7);

        headers.put("token",token);


        log.warn(token);

        ResponseEntity<ValidationResponseDTO> validationResult = userValidator.validateUser(headers);

//        log.info(validationResult.getIsTokenValid().toString());
//
//        if (validationResult.getIsTokenValid()){
//            filterChain.doFilter(request, response);
//        } else throw new UserValidationFailedException("Failed to validate user");

        filterChain.doFilter(request, response);


    }
}
