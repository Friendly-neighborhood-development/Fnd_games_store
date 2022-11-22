package com.fnd.games_store.games.service;



import com.fnd.games_store.games.dto.GameRequestDTO;
import com.fnd.games_store.games.entity.Game;
import com.fnd.games_store.games.dto.GameResponseDTO;
import com.fnd.games_store.games.exceptions.GameAlreadyExistException;
import com.fnd.games_store.games.exceptions.GameNotFoundException;
import com.fnd.games_store.games.repository.GameRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;
@CacheConfig(cacheNames = "games")
@Cacheable
@Service
@Slf4j
public class GameService {

    private final GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public GameResponseDTO getGameById(String requestedGameId){
        Game foundGameById = gameRepository.findById(requestedGameId).orElseThrow(GameNotFoundException::new);
        return new GameResponseDTO(foundGameById);
    }

   public List<GameResponseDTO> getGamesCatalogue(){
        return gameRepository.findAll().stream().map(GameResponseDTO::new).collect(Collectors.toList());
    }

   public GameResponseDTO createGameEntry(GameRequestDTO creatingGameBody) {
        Game gameFound = gameRepository.getGameByName(creatingGameBody.getName());
        if (gameFound != null ){
            throw new GameAlreadyExistException("This game entry already exist in database");
        } else {
            Game creatingGameEntry = new Game(creatingGameBody.getName(), creatingGameBody.getGenre(), creatingGameBody.getReleaseDate(),
                    creatingGameBody.getDeveloper(), creatingGameBody.getPublisher(), creatingGameBody.getPlatform(),
                    creatingGameBody.getFeatures(),creatingGameBody.getPrice(), creatingGameBody.getDiscount(),
                    creatingGameBody.getDescription(), creatingGameBody.getBase64Image());
            return new GameResponseDTO(gameRepository.save(creatingGameEntry));
        }

    }

    public GameResponseDTO updateGameEntry(String updatingGameId, GameRequestDTO newGameBody) {
            gameRepository.findById(updatingGameId).orElseThrow(GameNotFoundException::new);
            Game updatingGameEntry = new Game(newGameBody.getName(), newGameBody.getGenre(), newGameBody.getReleaseDate(),
                                              newGameBody.getDeveloper(), newGameBody.getPublisher(), newGameBody.getPlatform(),
                                              newGameBody.getFeatures(),newGameBody.getPrice(), newGameBody.getDiscount(),
                                              newGameBody.getDescription(), newGameBody.getBase64Image());
            updatingGameEntry.setId(updatingGameId);
            return new GameResponseDTO(gameRepository.save(updatingGameEntry));
    }

        public void deleteGameEntry(String deletingGameId){
        gameRepository.deleteById(deletingGameId);
    }

}
