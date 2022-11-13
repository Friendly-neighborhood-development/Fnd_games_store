package com.fnd.games_store.login.service.implementation;


import com.fnd.games_store.login.jwt_utils.implementation.JwtGeneratorImpl;
import com.fnd.games_store.login.jwt_utils.implementation.UserDetailsServiceImpl;
import com.fnd.games_store.login.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional
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
    public String login(String username, String password) {

        UserDetails loadedUser = userDetails.loadUserByUsername(username);

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password,loadedUser.getAuthorities()));

        UsernamePasswordAuthenticationToken authToken =  new UsernamePasswordAuthenticationToken(username,password, loadedUser.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authToken);

        return jwtGenerator.generateJwtToken(loadedUser);



    }

}
