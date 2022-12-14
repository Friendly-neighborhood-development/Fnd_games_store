package com.fnd.games_store.test.jwt_utils;


import com.fnd.games_store.login.LoginApplication;
import com.fnd.games_store.login.entity.Account;
import com.fnd.games_store.login.exception.AccountNotFoundException;
import com.fnd.games_store.login.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTestContextBootstrapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.test.context.BootstrapWith;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


@DataJpaTest
@BootstrapWith(SpringBootTestContextBootstrapper.class)
@SpringBootTest(classes = LoginApplication.class)
@Slf4j
public class LoadUserByUserName_IntegrationTest {

    @Autowired
    private AccountRepository repository;


    @Test
    void loadUserByUserName_shouldLoadUserWithAdminUsername(){
        assertThat(userFromDB("admin")).isEqualTo(createProperAdminUserInstance());
    }

    private User createProperAdminUserInstance(){

        List<GrantedAuthority> adminGrantedAuthorities = new ArrayList<>();

//        Authority adminAuthority = new Authority("1", "super_user");
//        Authority staffAuthority = new Authority("2", "staff_user");
//        Authority regularAuthority = new Authority("3", "regular_user");
//
//
//        adminGrantedAuthorities.add(adminAuthority);
//        adminGrantedAuthorities.add(staffAuthority);
//        adminGrantedAuthorities.add(regularAuthority);

        return new User("admin",
                "",
                true,
                true,
                true,
                true,
                adminGrantedAuthorities);
    }


    private User userFromDB(String username){
        final Account userAccount = repository.findUserByUsername(username).orElseThrow(()-> new AccountNotFoundException("Account not found"));
        return new User(userAccount.getUsername(),
                userAccount.getPassword(),
                userAccount.getIsAccountEnabled(),
                checkIfDateExpired(userAccount.getExpirationDate()),
                checkIfDateExpired(userAccount.getCredentialsExpirationDate()),
                userAccount.getIsAccountNonLocked(),
                userAccount.getAuthorities());
    }

    private Boolean checkIfDateExpired(OffsetDateTime checkingDate) {

        OffsetDateTime currentDate = OffsetDateTime.now();

        if (currentDate.isBefore(checkingDate)) {
            return true;
        } else {
            return false;
        }

    }

}
