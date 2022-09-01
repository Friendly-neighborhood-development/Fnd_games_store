package com.fnd.games_store.users.repository;

import com.fnd.games_store.users.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersAccountRepository extends JpaRepository<UserAccount, String> {

    Optional<UserAccount> findUserByUsername(String username);

}
