package com.fnd.games_store.login.service.implementation;


import com.fnd.games_store.login.dto.LoginResponseDTO;
import com.fnd.games_store.login.jwt_utils.JwtGenerator;
import com.fnd.games_store.login.repository.AccountRepository;
import com.fnd.games_store.login.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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

    private final AccountRepository accountRepository;

    @Autowired
    public LoginServiceImpl(AuthenticationManager authenticationManager, UserDetailsService userDetails, JwtGenerator jwtGenerator, AccountRepository accountRepository) {
        this.authenticationManager = authenticationManager;
        this.userDetails = userDetails;
        this.jwtGenerator = jwtGenerator;
        this.accountRepository = accountRepository;
    }

    @Override
    public LoginResponseDTO login(String username, String password) {

        UserDetails loadedUser = userDetails.loadUserByUsername(username);

        String userId = accountRepository.findAccountByUsername(username).get().getId();

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password,loadedUser.getAuthorities()));

        return new LoginResponseDTO(userId, jwtGenerator.generateJwtToken(loadedUser));
    }
}
