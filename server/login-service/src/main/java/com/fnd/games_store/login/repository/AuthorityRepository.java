package com.fnd.games_store.login.repository;

import com.fnd.games_store.login.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorityRepository extends JpaRepository<Authority, String> {

    Optional<Authority> findAuthorityByName(String name);



}
