package com.fnd.games_store.orders.repository;

import com.fnd.games_store.orders.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, String> {


}
