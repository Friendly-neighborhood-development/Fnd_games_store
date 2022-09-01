package com.fnd.games_store.users.repository;

import com.fnd.games_store.users.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersAccountRepository extends JpaRepository<UserAccount, String> {




}
