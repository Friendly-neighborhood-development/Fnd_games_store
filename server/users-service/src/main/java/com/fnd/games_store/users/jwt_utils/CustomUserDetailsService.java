package com.fnd.games_store.users.jwt_utils;

import com.fnd.games_store.users.entity.UserAccount;
import com.fnd.games_store.users.repository.UsersAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.ArrayList;

public class CustomUserDetailsService implements UserDetailsService {


    private final UsersAccountRepository usersAccountRepository;

    @Autowired
    public CustomUserDetailsService(UsersAccountRepository usersAccountRepository) {
        this.usersAccountRepository = usersAccountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        final UserAccount userAccount = usersAccountRepository.findUserByUsername(username).get();
        return new User(userAccount.getUsername(),userAccount.getPassword(), new ArrayList<>());
    }



}
