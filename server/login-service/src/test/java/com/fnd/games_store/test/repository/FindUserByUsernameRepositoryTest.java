package com.fnd.games_store.test.repository;


import com.fnd.games_store.login.LoginApplication;
import com.fnd.games_store.login.entity.Account;
import com.fnd.games_store.login.entity.Authority;
import com.fnd.games_store.login.repository.AccountRepository;
import com.fnd.games_store.login.repository.AuthorityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTestContextBootstrapper;
import org.springframework.test.context.BootstrapWith;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@BootstrapWith(SpringBootTestContextBootstrapper.class)
@SpringBootTest(classes = LoginApplication.class)
public class FindUserByUsernameRepositoryTest {


    @Autowired
    private AccountRepository repository;

    @Autowired
    private AuthorityRepository authorityRepository;

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


    private Account createProperAdminAccount(String username, String date){

        Account properAdminAccount = new Account();
        properAdminAccount.setId("1");
        properAdminAccount.setUsername(username);
        properAdminAccount.setPassword("$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6");
        properAdminAccount.setEmail("admin@gmail.com");
        properAdminAccount.setExpirationDate(LocalDate.parse(date));
        properAdminAccount.setIsAccountEnabled(true);
        properAdminAccount.setCredentialsExpirationDate(LocalDate.parse(date.toString()));
        properAdminAccount.setIsAccountNonLocked(true);


        //TODO refactoring required
        List<Authority> adminGrantedAuthorities = new ArrayList<>();
        Authority adminAuthority = authorityRepository.findById("1").get();
        Authority staffAuthority = authorityRepository.findById("2").get();
        Authority regularAuthority = authorityRepository.findById("3").get();

        adminGrantedAuthorities.add(adminAuthority);
        adminGrantedAuthorities.add(staffAuthority);
        adminGrantedAuthorities.add(regularAuthority);

        properAdminAccount.setAuthority(adminGrantedAuthorities);

        return properAdminAccount;
    }


}
