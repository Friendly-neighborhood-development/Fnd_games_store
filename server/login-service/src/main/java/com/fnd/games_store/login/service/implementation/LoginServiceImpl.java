package com.fnd.games_store.login.service.implementation;

import com.fnd.games_store.login.jwt_utils.implementations.CustomUserDetailsService;
import com.fnd.games_store.login.jwt_utils.implementations.JwtGeneratorImpl;
import com.fnd.games_store.login.service.LoginService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {


    private JwtGeneratorImpl jwtGeneratorimpl;

    private CustomUserDetailsService userDetails;

    @Override
    public String login(String username,String password) {

        UsernamePasswordAuthenticationToken authToken =  new UsernamePasswordAuthenticationToken(username,password);

        SecurityContextHolder.getContext().setAuthentication(authToken);

        SecurityContextHolder.getContext().getAuthentication();
        return generateToken(username);
    }



    private String generateToken(String username){
        return jwtGeneratorimpl.generateAccessToken(userDetails.loadUserByUsername(username));
    }

}
