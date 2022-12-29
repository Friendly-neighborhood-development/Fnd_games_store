package com.fnd.games_store.games.repository;

import com.fnd.games_store.games.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GameRepository extends JpaRepository<Game, String> {


    public Game getGameById(String id);
    public Optional<Game> getGameByName(String name);

}
