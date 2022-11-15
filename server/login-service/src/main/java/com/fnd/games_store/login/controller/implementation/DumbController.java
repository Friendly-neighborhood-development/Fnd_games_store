package com.fnd.games_store.login.controller.implementation;

import com.fnd.games_store.login.entity.Account;
import com.fnd.games_store.login.entity.Authority;
import com.fnd.games_store.login.repository.AccountRepository;
import com.fnd.games_store.login.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dumb")
@Transactional
public class DumbController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AuthorityRepository authorityRepository;


    @GetMapping("/accounts")
    public List<Account> getEntries(){
        return accountRepository.findAll();
    }

    @GetMapping("/auth")
    public List<Authority> getAuthEntries(){
        return authorityRepository.findAll();
    }


}
