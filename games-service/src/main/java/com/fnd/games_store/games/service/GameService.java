package com.fnd.games_store.games.service;

import com.fnd.games_store.games.entity.Game;
import com.fnd.games_store.games.entity.dto.GameResponseDTO;
import com.fnd.games_store.games.exceptions.GameNotFoundException;
import com.fnd.games_store.games.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@Service
public class GameService {

    private final GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Game getGameByName(String name){
       return gameRepository.findById(convertNameToId(name)).orElseThrow(()-> new GameNotFoundException("Requested game not found"));
    }

   public List<Game> getGamesCatalogue(){
        return gameRepository.findAll();
    }


    // TODO for now I don't know how to better deal with this method in case if a game would be found, refactor later
   public String createGameEntry(String name, String genre, OffsetDateTime releaseDate, String developer, String publisher,
                                  String platform, String features, BigDecimal price, BigDecimal discount, String description) {
            Game creatingGameEntry = new Game(name, genre, releaseDate, developer, publisher,
                                              platform, features,price, discount,description);
            return gameRepository.save(creatingGameEntry).getId();
    }

    public GameResponseDTO updateGameEntry(String name, String genre, OffsetDateTime releaseDate, String developer, String publisher,
                                String platform, String features, BigDecimal price, BigDecimal discount, String description) {
            Game updatingGameEntry = new Game(name, genre, releaseDate, developer, publisher,
                                              platform, features,price, discount,description);
            updatingGameEntry.setId(gameRepository.getGameByName(updatingGameEntry.getName()).getId());
            return new GameResponseDTO(gameRepository.save(updatingGameEntry));
    }

        public void deleteGameEntry(String name){
            gameRepository.deleteById(convertNameToId(name));
    }

        private String convertNameToId(String name){
            Game requestedGame = gameRepository.getGameByName(name);
            return requestedGame.getId();
    }

}
