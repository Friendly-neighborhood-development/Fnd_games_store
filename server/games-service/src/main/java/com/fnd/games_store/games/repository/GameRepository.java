package com.fnd.games_store.games.repository;

import com.fnd.games_store.games.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, String> {


    public Game getGameById(String id);
    public Game getGameByName(String name);

}
