package com.fnd.games_store.login.service.implementation;


import com.fnd.games_store.login.jwt_utils.implementation.JwtGeneratorImpl;
import com.fnd.games_store.login.jwt_utils.implementation.UserDetailsServiceImpl;
import com.fnd.games_store.login.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    private final UserDetailsServiceImpl userDetails;
    private final JwtGeneratorImpl jwtGenerator;
    @Autowired
    public LoginServiceImpl(UserDetailsServiceImpl userDetails, JwtGeneratorImpl jwtGenerator) {
        this.userDetails = userDetails;
        this.jwtGenerator = jwtGenerator;
    }

    @Override
    public String login(String username,String password) {

        return jwtGenerator.generateJwtToken(userDetails.loadUserByUsername(username));
    }



}
