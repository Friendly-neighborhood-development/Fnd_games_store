package com.fnd.games_store.test.service;


import com.fnd.games_store.login.LoginApplication;
import com.fnd.games_store.login.repository.AccountRepository;
import com.fnd.games_store.login.repository.AuthorityRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTestContextBootstrapper;
import org.springframework.test.context.BootstrapWith;


import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@BootstrapWith(SpringBootTestContextBootstrapper.class)
@SpringBootTest(classes = LoginApplication.class)
@Slf4j
public class RegistrationTest {


    private AccountRepository accountRepository;

    private AuthorityRepository authorityRepository;

    @Autowired
    public RegistrationTest(AccountRepository accountRepository, AuthorityRepository authorityRepository) {
        this.accountRepository = accountRepository;
        this.authorityRepository = authorityRepository;
    }

    @Test
    void getAnythingFromDbTest(){
       assertThat(authorityRepository.findAll()).isNotNull();
    }




}
