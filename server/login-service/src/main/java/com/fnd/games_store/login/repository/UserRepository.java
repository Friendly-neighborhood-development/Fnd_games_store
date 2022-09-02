package com.fnd.games_store.login.repository;

import com.fnd.games_store.login.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Account, String>{

    Optional<Account> findUserByUsername(String username);


}
