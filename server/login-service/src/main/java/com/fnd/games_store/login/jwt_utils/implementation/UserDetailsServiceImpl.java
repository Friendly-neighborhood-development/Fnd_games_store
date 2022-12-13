package com.fnd.games_store.login.jwt_utils.implementation;

import com.fnd.games_store.login.entity.Account;
import com.fnd.games_store.login.exception.AccountNotFoundException;
import com.fnd.games_store.login.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;



@Component
public class UserDetailsServiceImpl implements UserDetailsService {


    private final AccountRepository accountReposiory;


    @Autowired
    public UserDetailsServiceImpl(AccountRepository accountReposiory) {
        this.accountReposiory = accountReposiory;
    }


    @Override
    public UserDetails loadUserByUsername(String username) {
        final Account userAccount = accountReposiory.findUserByUsername(username).orElseThrow(()-> new AccountNotFoundException("Account not found"));
        return new User(userAccount.getUsername(),userAccount.getPassword(), userAccount.getAuthorities());
    }

}
