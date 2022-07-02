package com.fnd.games_store.games.service;

import com.fnd.games_store.games.entity.Game;
import com.fnd.games_store.games.controller.dto.GameResponseDTO;
import com.fnd.games_store.games.exceptions.GameNotFoundException;
import com.fnd.games_store.games.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class GameService {

    private GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public GameResponseDTO getGameById(String id){
        Game foundGameById = gameRepository.findById(id).orElseThrow(()-> new GameNotFoundException("Requested game not found"));
        return new GameResponseDTO(foundGameById);
    }

   public List<Game> getGamesCatalogue(){
        return gameRepository.findAll();
    }


    // TODO for now I don't know how to better deal with this method in case if a game would be found, refactor later
   public String createGameEntry(String name, String genre, String releaseDate, String developer, String publisher,
                                  String platform, String features, BigDecimal price, BigDecimal discount, String description) {
            Game creatingGameEntry = new Game(name, genre, releaseDate, developer, publisher,
                                              platform, features,price, discount,description);
            return gameRepository.save(creatingGameEntry).getId();
    }

    public GameResponseDTO updateGameEntry(String updatingAccountId, String name, String genre, String releaseDate, String developer, String publisher,
                                String platform, String features, BigDecimal price, BigDecimal discount, String description) {
            Game updatingGameEntry = new Game(name, genre, releaseDate, developer, publisher,
                                              platform, features,price, discount,description);
            updatingGameEntry.setId(updatingAccountId);
            return new GameResponseDTO(gameRepository.save(updatingGameEntry));
    }

        public String deleteGameEntry(String deletingGameId){
        Game gameToBeDeleted = gameRepository.getGameById(deletingGameId);
        gameRepository.deleteById(deletingGameId);
            return gameToBeDeleted.getId();
    }


    @Profile("test")
    public String defaultMessage(){
        return "Test succeed";
    }

}
