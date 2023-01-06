package com.fnd.games_store.test.repository;


import com.fnd.games_store.login.LoginApplication;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTestContextBootstrapper;
import org.springframework.test.context.BootstrapWith;

@DataJpaTest
@BootstrapWith(SpringBootTestContextBootstrapper.class)
@SpringBootTest(classes = LoginApplication.class)
public class AccountRegistration extends RepositoryTestCommons{








}
