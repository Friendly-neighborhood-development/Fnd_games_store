package com.fnd.games_store.login.service.implementation;


import com.fnd.games_store.login.entity.Account;
import com.fnd.games_store.login.repository.AccountRepository;
import com.fnd.games_store.login.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    @Autowired
    private final AccountRepository accountRepository;

    public LoginServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public String login(String username,String password) {

        Account account = accountRepository.findUserByUsername(username).get();


        return account.toString();
    }



}
