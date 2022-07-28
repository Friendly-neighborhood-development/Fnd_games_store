package com.fnd.games_store.games.service;


import com.fnd.games_store.games.GamesApplication;
import com.fnd.games_store.games.controller.dto.GameRequestDTO;
import com.fnd.games_store.games.entity.Game;
import com.fnd.games_store.games.controller.dto.GameResponseDTO;
import com.fnd.games_store.games.exceptions.GameNotFoundException;
import com.fnd.games_store.games.repository.GameRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
@CacheConfig(cacheNames = "games")
@Cacheable
@Service
public class GameService {

    private static final Logger logger = LoggerFactory.getLogger(GamesApplication.class);

    private GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public GameResponseDTO getGameById(String id){
        Game foundGameById = gameRepository.findById(id).orElseThrow(GameNotFoundException::new);
        return new GameResponseDTO(foundGameById);
    }
//   @Cacheable
   public List<GameResponseDTO> getGamesCatalogue(){
        logger.info("service started");
        Instant startTime = Instant.now();
        List<GameResponseDTO> listOfGames = gameRepository.findAll().stream().map(GameResponseDTO::new).collect(Collectors.toList());
        Instant endTime = Instant.now();
        logger.info("service terminated with execution time: " + Duration.between(startTime,endTime).toMillis());
        return listOfGames;
    }

   public GameResponseDTO createGameEntry(GameRequestDTO gameRequestDTO) {

        Game gameFound = gameRepository.getGameByName(gameRequestDTO.getName());

        if (gameFound != null ){
            return new GameResponseDTO(gameRepository.getGameByName(gameRequestDTO.getName()));
        } else {
            Game creatingGameEntry = new Game(gameRequestDTO.getName(), gameRequestDTO.getGenre(), gameRequestDTO.getReleaseDate(),
                    gameRequestDTO.getDeveloper(), gameRequestDTO.getPublisher(), gameRequestDTO.getPlatform(),
                    gameRequestDTO.getFeatures(),gameRequestDTO.getPrice(), gameRequestDTO.getDiscount(),
                    gameRequestDTO.getDescription(), gameRequestDTO.getBase64Image());
            return new GameResponseDTO(gameRepository.save(creatingGameEntry));
        }

    }

    public GameResponseDTO updateGameEntry(String updatingGameId, GameRequestDTO gameRequestDTO) {
            gameRepository.findById(updatingGameId).orElseThrow(GameNotFoundException::new);
            Game updatingGameEntry = new Game(gameRequestDTO.getName(), gameRequestDTO.getGenre(), gameRequestDTO.getReleaseDate(),
                                              gameRequestDTO.getDeveloper(), gameRequestDTO.getPublisher(), gameRequestDTO.getPlatform(),
                                              gameRequestDTO.getFeatures(),gameRequestDTO.getPrice(), gameRequestDTO.getDiscount(),
                                              gameRequestDTO.getDescription(), gameRequestDTO.getBase64Image());
            updatingGameEntry.setId(updatingGameId);
            return new GameResponseDTO(gameRepository.save(updatingGameEntry));
    }

        public void deleteGameEntry(String deletingGameId){
        Game gameToBeDeleted = gameRepository.getGameById(deletingGameId);
        gameRepository.deleteById(deletingGameId);
    }

}
