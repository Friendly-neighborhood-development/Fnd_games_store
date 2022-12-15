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
public class FindUserByUsername_IntegrationTest {


    @Autowired
    private AccountRepository repository;

    private Account loadedAdminAccount;

    private CharSequence date = "2030-01-01";


    @Test
    void findAccountByUsername_ShouldReturnProperAccount(){
        assertThat(loadedAdminAccount).isEqualTo(createProperAdminAccount("admin"));
    }



    private Account createProperAdminAccount(String username){

        Account properAdminAccount = new Account();
        properAdminAccount.setId("1");
        properAdminAccount.setUsername("admin");
        properAdminAccount.setPassword("$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6");
        properAdminAccount.setEmail("admin@gmail.com");
        properAdminAccount.setExpirationDate(LocalDate.parse(date.toString()));
        properAdminAccount.setIsAccountEnabled(true);
        properAdminAccount.setCredentialsExpirationDate(LocalDate.parse(date.toString()));
        properAdminAccount.setIsAccountNonLocked(true);



        List<Authority> adminGrantedAuthorities = new ArrayList<>();
        Authority adminAuthority = new Authority("1", "super_user");
        Authority staffAuthority = new Authority("2", "staff_user");
        Authority regularAuthority = new Authority("3", "regular_user");

        adminGrantedAuthorities.add(adminAuthority);
        adminGrantedAuthorities.add(staffAuthority);
        adminGrantedAuthorities.add(regularAuthority);

        properAdminAccount.setAuthorities(adminGrantedAuthorities);

        return properAdminAccount;
    }


    @BeforeEach
    void testSetup(){
        loadedAdminAccount = repository.findAccountByUsername("admin").get();
    }


}
