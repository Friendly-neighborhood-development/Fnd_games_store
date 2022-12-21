package com.fnd.games_store.login.service.implementation;


import com.fnd.games_store.login.dto.LoginResponseDTO;
import com.fnd.games_store.login.jwt_utils.JwtGenerator;
import com.fnd.games_store.login.repository.AccountRepository;
import com.fnd.games_store.login.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional
public class LoginServiceImpl implements LoginService {

    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetails;
    private final JwtGenerator jwtGenerator;

    private final AccountRepository accountRepository;

    @Autowired
    public LoginServiceImpl(PasswordEncoder passwordEncoder, UserDetailsService userDetails, JwtGenerator jwtGenerator, AccountRepository accountRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userDetails = userDetails;
        this.jwtGenerator = jwtGenerator;
        this.accountRepository = accountRepository;
    }

    @Override
    public LoginResponseDTO login(String username, String password) {

        UserDetails loadedUser = userDetails.loadUserByUsername(username);

        String userId = accountRepository.findAccountByUsername(username).get().getId();

        passwordEncoder.matches(password, loadedUser.getPassword());

        return new LoginResponseDTO(userId, jwtGenerator.generateJwtToken(loadedUser));
    }
}
