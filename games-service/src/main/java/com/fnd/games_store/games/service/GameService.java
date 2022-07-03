package com.fnd.games_store.games.service;

import com.fnd.games_store.games.controller.dto.GameRequestDTO;
import com.fnd.games_store.games.entity.Game;
import com.fnd.games_store.games.controller.dto.GameResponseDTO;
import com.fnd.games_store.games.exceptions.GameAlreadyExistException;
import com.fnd.games_store.games.exceptions.GameNotFoundException;
import com.fnd.games_store.games.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    private GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public GameResponseDTO getGameById(String id){
        Game foundGameById = gameRepository.findById(id).orElseThrow(GameNotFoundException::new);
        return new GameResponseDTO(foundGameById);
    }

   public List<GameResponseDTO> getGamesCatalogue(){
        return gameRepository.findAll().stream().map(GameResponseDTO::new).collect(Collectors.toList());
    }

   public GameResponseDTO createGameEntry(GameRequestDTO gameRequestDTO) {

        Game gameFound = gameRepository.getGameByName(gameRequestDTO.getName());

        if (gameFound != null ){
            return new GameResponseDTO(gameRepository.getGameByName(gameRequestDTO.getName()));
        } else {
            Game creatingGameEntry = new Game(gameRequestDTO.getName(), gameRequestDTO.getGenre(), gameRequestDTO.getReleaseDate(),
                    gameRequestDTO.getDeveloper(), gameRequestDTO.getPublisher(), gameRequestDTO.getPlatform(),
                    gameRequestDTO.getFeatures(),gameRequestDTO.getPrice(), gameRequestDTO.getDiscount(),gameRequestDTO.getDescription());
            return new GameResponseDTO(gameRepository.save(creatingGameEntry));
        }

    }

    public GameResponseDTO updateGameEntry(String updatingGameId, GameRequestDTO gameRequestDTO) {
            gameRepository.findById(updatingGameId).orElseThrow(GameNotFoundException::new);
            Game updatingGameEntry = new Game(gameRequestDTO.getName(), gameRequestDTO.getGenre(), gameRequestDTO.getReleaseDate(),
                                              gameRequestDTO.getDeveloper(), gameRequestDTO.getPublisher(), gameRequestDTO.getPlatform(),
                                              gameRequestDTO.getFeatures(),gameRequestDTO.getPrice(), gameRequestDTO.getDiscount(),gameRequestDTO.getDescription());
            updatingGameEntry.setId(updatingGameId);
            return new GameResponseDTO(gameRepository.save(updatingGameEntry));
    }

        public void deleteGameEntry(String deletingGameId){
        Game gameToBeDeleted = gameRepository.getGameById(deletingGameId);
        gameRepository.deleteById(deletingGameId);
    }


    @Profile("test")
    public String defaultMessage(){
        return "Test succeed";
    }

}
