package com.fnd.games_store.login.service.implementation;


import com.fnd.games_store.login.dto.LoginResponseDTO;
import com.fnd.games_store.login.exception.AccountNotFoundException;
import com.fnd.games_store.login.exception.InvalidPasswordException;
import com.fnd.games_store.login.jwt_utils.JwtGenerator;
import com.fnd.games_store.login.repository.AccountRepository;
import com.fnd.games_store.login.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
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
    @Transactional(label = "user_login",
            propagation = Propagation.REQUIRED,
            isolation = Isolation.REPEATABLE_READ,
            timeout = 5,
            readOnly = true,
            rollbackFor = {AccountNotFoundException.class, InvalidPasswordException.class})
    @Override
    public LoginResponseDTO login(String username, String password) {

        UserDetails loadedUser = userDetails.loadUserByUsername(username);

        String userId = accountRepository.findAccountByUsername(username).get().getId();

        log.info(userId);

        if(passwordEncoder.matches(password, loadedUser.getPassword())){
            return new LoginResponseDTO(userId, jwtGenerator.generateJwtToken(loadedUser));
        } else throw new InvalidPasswordException("invalid password");


    }
}
