package com.fnd.games_store.login.jwt_utils.implementations;

import com.fnd.games_store.login.entity.Account;
import com.fnd.games_store.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collection;


@Component
public class CustomUserDetailsService implements UserDetailsService {


    private final UserRepository userRepository;
    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Account foundUser = userRepository.findUserByUsername(username).get();

        return new User(foundUser.getUsername(),foundUser.getPassword(), foundUser.getAuthorities());
    }
}
