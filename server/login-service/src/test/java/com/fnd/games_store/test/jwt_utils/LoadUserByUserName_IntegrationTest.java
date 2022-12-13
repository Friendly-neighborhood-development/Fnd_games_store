package com.fnd.games_store.test.jwt_utils;


import com.fnd.games_store.login.LoginApplication;
import com.fnd.games_store.login.entity.Authority;
import com.fnd.games_store.login.repository.AccountRepository;
import com.netflix.discovery.converters.Auto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTestContextBootstrapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.test.context.BootstrapWith;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


@DataJpaTest
@BootstrapWith(SpringBootTestContextBootstrapper.class)
@SpringBootTest(classes = LoginApplication.class)
public class LoadUserByUserName_IntegrationTest {


    @Autowired
    private AccountRepository repository;

    private User properUser;

    @Test
    void loadUserByUserName_shouldReturnProperUserInstance(){
        assertThat(repository.findUserByUsername("admin").get()).isEqualTo(createProperUserInstance());
    }

    private User createProperUserInstance(){

        GrantedAuthority authority = new Authority();
        authority.getAuthority();

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        grantedAuthorities.add(new Authority());

        GrantedAuthority adminAuthorities = new Authority();

        return new User("admin",
                "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
                true,
                true,
                true,
                true,
                grantedAuthorities);
    }


}
