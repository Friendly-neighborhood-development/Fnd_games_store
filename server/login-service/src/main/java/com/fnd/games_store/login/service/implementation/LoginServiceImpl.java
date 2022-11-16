package com.fnd.games_store.login.service.implementation;


import com.fnd.games_store.login.jwt_utils.JwtGenerator;
import com.fnd.games_store.login.jwt_utils.implementation.JwtGeneratorImpl;
import com.fnd.games_store.login.jwt_utils.implementation.UserDetailsServiceImpl;
import com.fnd.games_store.login.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional
public class LoginServiceImpl implements LoginService {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetails;
    private final JwtGenerator jwtGenerator;

    @Autowired
    public LoginServiceImpl(AuthenticationManager authenticationManager, UserDetailsService userDetails, JwtGenerator jwtGenerator) {
        this.authenticationManager = authenticationManager;
        this.userDetails = userDetails;
        this.jwtGenerator = jwtGenerator;
    }

    @Override
    public String login(String username, String password) {

        UserDetails loadedUser = userDetails.loadUserByUsername(username);

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password,loadedUser.getAuthorities()));

        return jwtGenerator.generateJwtToken(loadedUser);
    }
}
