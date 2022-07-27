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

    @RequestMapping(method = RequestMethod.GET, value = "/getAll", produces = "application/json"
            )
    public List<GameResponseDTO> getGameCatalogue(){
        return gameService.getGamesCatalogue();
    }

//,headers = {"Access-Control-Allow-Origin=*", "Access-Control-Allow-Credentials=true"}


    @PostMapping("/create")
    public GameResponseDTO createGameEntry(@RequestBody GameRequestDTO gameRequestDTO){
        return gameService.createGameEntry(gameRequestDTO);
    }

    @PutMapping("/update/{requestedGameId}")
    public GameResponseDTO updateGameEntry(@PathVariable String requestedGameId, @RequestBody GameRequestDTO gameRequestDTO){
        return gameService.updateGameEntry(requestedGameId, gameRequestDTO);
    }

    @DeleteMapping("/delete/{requestedGameId}")
    public void deleteGameEntry(@PathVariable String requestedGameId){
        gameService.deleteGameEntry(requestedGameId);
    }

}
