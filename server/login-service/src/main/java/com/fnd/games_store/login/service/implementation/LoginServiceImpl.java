package com.fnd.games_store.login.service.implementation;


import com.fnd.games_store.login.jwt_utils.implementation.JwtGeneratorImpl;
import com.fnd.games_store.login.jwt_utils.implementation.UserDetailsServiceImpl;
import com.fnd.games_store.login.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsServiceImpl userDetails;
    private final JwtGeneratorImpl jwtGenerator;
    @Autowired
    public LoginServiceImpl(AuthenticationManager authenticationManager, UserDetailsServiceImpl userDetails, JwtGeneratorImpl jwtGenerator) {
        this.authenticationManager = authenticationManager;
        this.userDetails = userDetails;
        this.jwtGenerator = jwtGenerator;
    }

    @Override
    public String login(String username,String password) {

        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (BadCredentialsException e){
            throw new RuntimeException("INVALID_CREDENTIALS", e);
        }

        log.info(SecurityContextHolder.getContext().getAuthentication().toString());

        return jwtGenerator.generateJwtToken(userDetails.loadUserByUsername(username));
    }

}
