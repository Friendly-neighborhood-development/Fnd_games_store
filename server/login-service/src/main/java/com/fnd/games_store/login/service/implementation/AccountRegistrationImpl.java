package com.fnd.games_store.login.service.implementation;


import com.fnd.games_store.login.dto.AccountRequestDTO;
import com.fnd.games_store.login.dto.AccountResponseDTO;
import com.fnd.games_store.login.entity.Account;
import com.fnd.games_store.login.entity.Authority;
import com.fnd.games_store.login.exception.AccountAlreadyExistsException;
import com.fnd.games_store.login.repository.AccountRepository;
import com.fnd.games_store.login.repository.AuthorityRepository;
import com.fnd.games_store.login.service.AccountRegistration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AccountRegistrationImpl implements AccountRegistration {

    @Value("${variables.common.new_account_expiration_date}")
    private String expirationDate;

    private final AccountRepository accountRepository;

    private final PasswordEncoder encoder;

    private final AuthorityRepository authorityRepository;

    private List<Authority> accountAuthoritiesList = new ArrayList<>();

    @Autowired
    public AccountRegistrationImpl(AccountRepository accountRepository, PasswordEncoder encoder, AuthorityRepository authorityRepository) {
        this.accountRepository = accountRepository;
        this.encoder = encoder;
        this.authorityRepository = authorityRepository;
    }
    @Transactional(label = "account_registration", propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ, timeout = 5, rollbackFor = AccountAlreadyExistsException.class)
    @Override
    public AccountResponseDTO register(AccountRequestDTO accountRequestDTO) {

        Boolean isAccountWithSpecifiedUsernameExists = accountRepository.findAccountByUsername(accountRequestDTO.getUsername()).isPresent();

        if(!isAccountWithSpecifiedUsernameExists){
            Account newAccount = new Account();
            Authority regularUserAuthority = authorityRepository.findById("3").get();

            newAccount.setUsername(accountRequestDTO.getUsername());
            newAccount.setPassword(encoder.encode(accountRequestDTO.getPassword()));
            newAccount.setEmail(accountRequestDTO.getEmail());
            newAccount.setExpirationDate(LocalDate.parse(expirationDate));
            newAccount.setIsAccountNonLocked(true);
            newAccount.setCredentialsExpirationDate(LocalDate.parse(expirationDate));
            newAccount.setIsAccountEnabled(true);

            accountAuthoritiesList.add(regularUserAuthority);
            newAccount.setAuthority(accountAuthoritiesList);

            accountRepository.save(newAccount);

            return new AccountResponseDTO(newAccount.getUsername(), newAccount.getId());
        } else{
            throw new AccountAlreadyExistsException("Account with this username already exists");
        }
    }
}
