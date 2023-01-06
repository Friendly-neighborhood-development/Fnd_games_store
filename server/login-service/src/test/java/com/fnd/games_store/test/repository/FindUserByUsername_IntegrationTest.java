package com.fnd.games_store.test.repository;


import com.fnd.games_store.login.LoginApplication;
import com.fnd.games_store.login.entity.Account;
import com.fnd.games_store.login.entity.Authority;
import com.fnd.games_store.login.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTestContextBootstrapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.test.context.BootstrapWith;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@BootstrapWith(SpringBootTestContextBootstrapper.class)
@SpringBootTest(classes = LoginApplication.class)
public class FindUserByUsername_IntegrationTest extends RepositoryTestCommons{


    @Autowired
    private AccountRepository repository;

    private Account loadedAdminAccount;

    private CharSequence date = "2030-01-01";

    private String username = "admin";

    private Account expectedEntity;


    @Test
    void findAccountByUsername_ShouldReturnProperAccount(){
        assertThat(loadedAdminAccount).isEqualTo(expectedEntity);
    }

    @BeforeEach
    void testSetup(){
        loadedAdminAccount = repository.findAccountByUsername("admin").get();
        expectedEntity = createProperAdminAccount(username, date);
    }


}
