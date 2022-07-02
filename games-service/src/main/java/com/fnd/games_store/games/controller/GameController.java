package com.fnd.games_store.games.controller;

import com.fnd.games_store.games.controller.dto.GameRequestDTO;
import com.fnd.games_store.games.controller.dto.GameResponseDTO;
import com.fnd.games_store.games.service.GameService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

@RestController
public class GameController {


    private GameService gameService;
    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/get/{requestedGameId}")
    public GameResponseDTO getGameById(@PathVariable String requestedGameId){
        return gameService.getGameById(requestedGameId);
    }

    @GetMapping("/getAll")
    public List<GameResponseDTO> getGameCatalogue(){
        return gameService.getGamesCatalogue().stream().map(GameResponseDTO::new).collect(Collectors.toList());
    }

    @PostMapping("/create")
    public String createGameEntry(@RequestBody @NotNull GameRequestDTO gameRequestDTO){
        return gameService.createGameEntry(gameRequestDTO.getName(),gameRequestDTO.getGenre(), gameRequestDTO.getReleaseDate(), gameRequestDTO.getDeveloper(),
                gameRequestDTO.getPublisher(), gameRequestDTO.getPlatform(),gameRequestDTO.getFeatures(), gameRequestDTO.getPrice(), gameRequestDTO.getDiscount(),
                gameRequestDTO.getDescription());
    }

    @PutMapping("/update/{requestedGameId}")
    public GameResponseDTO updateGameEntry(@PathVariable String requestedGameId, @RequestBody @NotNull GameRequestDTO gameRequestDTO){
        return gameService.updateGameEntry(requestedGameId, gameRequestDTO.getName(),gameRequestDTO.getGenre(), gameRequestDTO.getReleaseDate(),
               gameRequestDTO.getDeveloper(), gameRequestDTO.getPublisher(), gameRequestDTO.getPlatform(),gameRequestDTO.getFeatures(),
               gameRequestDTO.getPrice(), gameRequestDTO.getDiscount(), gameRequestDTO.getDescription());

    }

    @DeleteMapping("/delete/{requestedGameId}")
    public void deleteGameEntry(@PathVariable String requestedGameId){
        gameService.deleteGameEntry(requestedGameId);
    }


    @Profile("test")
    @GetMapping("/default")
    public String printDefaultMessage(){
        return gameService.defaultMessage();
    }

}
