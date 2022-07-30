package com.fnd.games_store.games.controller;

import com.fnd.games_store.games.controller.dto.GameRequestDTO;
import com.fnd.games_store.games.controller.dto.GameResponseDTO;
import com.fnd.games_store.games.service.GameService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@NoArgsConstructor
@CrossOrigin
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
        return gameService.getGamesCatalogue();
    }

    @PostMapping("/create")
    public GameResponseDTO createGameEntry(@RequestBody GameRequestDTO creatingGameBody){
        return gameService.createGameEntry(creatingGameBody);
    }

    @PutMapping("/update/{updatingGameId}")
    public GameResponseDTO updateGameEntry(@PathVariable String updatingGameId, @RequestBody GameRequestDTO newGameBody){
        return gameService.updateGameEntry(updatingGameId, newGameBody);
    }

    @DeleteMapping("/delete/{deletingGameId}")
    public void deleteGameEntry(@PathVariable String deletingGameId){
        gameService.deleteGameEntry(deletingGameId);
    }

}
