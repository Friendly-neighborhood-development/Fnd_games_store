package com.fnd.games_store.test.repository;


import com.fnd.games_store.login.LoginApplication;
import com.fnd.games_store.login.dto.AccountRequestDTO;
import com.fnd.games_store.login.dto.AccountResponseDTO;
import com.fnd.games_store.login.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTestContextBootstrapper;
import org.springframework.test.context.BootstrapWith;

@DataJpaTest
@BootstrapWith(SpringBootTestContextBootstrapper.class)
@SpringBootTest(classes = LoginApplication.class)
public class AccountRegistration extends RepositoryTestCommons{


    @Autowired
    private AccountRepository repository;


    private String username = "Alfonso";

    private String password = "original_password_123";

    private String email = "alfonso@email.com";

    private AccountRequestDTO newAccountData;



    @Test
    void register_ShouldSaveNewAccountEntityToDB(){

    }



    private AccountRequestDTO createAppropriateNewAccountDTO(String username, String password, String email){
        AccountRequestDTO savingAccount = new AccountRequestDTO(username,password,email);
        return savingAccount;
    }






}
