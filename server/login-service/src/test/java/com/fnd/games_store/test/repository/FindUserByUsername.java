package com.fnd.games_store.test.repository;


import com.fnd.games_store.login.LoginApplication;
import com.fnd.games_store.login.entity.Account;
import com.fnd.games_store.login.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTestContextBootstrapper;
import org.springframework.test.context.BootstrapWith;


import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@BootstrapWith(SpringBootTestContextBootstrapper.class)
@SpringBootTest(classes = LoginApplication.class)
public class FindUserByUsername extends RepositoryTestCommons{


    @Autowired
    private AccountRepository repository;

    private Account loadedAdminAccount;

    @Value("${variables.common.new_account_expiration_date}")
    private String expirationDate;

    private String username = "admin";

    private Account expectedEntity;


    @Test
    void findAccountByUsername_ShouldReturnProperAccount(){
        assertThat(loadedAdminAccount).isEqualTo(expectedEntity);
    }

    @BeforeEach
    void testSetup(){
        loadedAdminAccount = repository.findAccountByUsername("admin").get();
        expectedEntity = createProperAdminAccount(username, expirationDate);
    }


}
