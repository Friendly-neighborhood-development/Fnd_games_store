package com.fnd.games_store.games.controller;

import com.fnd.games_store.games.entity.dto.GameRequestDTO;
import com.fnd.games_store.games.entity.dto.GameResponseDTO;
import com.fnd.games_store.games.service.GameService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

@RestController
public class GameController {


    private final GameService gameService;
    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }



    @GetMapping("/get/{name}")
    public GameResponseDTO getGameEntry(@RequestParam String name){
        return new GameResponseDTO(gameService.getGameByName(name));
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

    @PutMapping("/update/{name}")
    public GameResponseDTO updateGameEntry(@PathVariable String name, @RequestBody GameRequestDTO requestDTO){
        return gameService.updateGameEntry(requestDTO.getName(),requestDTO.getGenre(), requestDTO.getReleaseDate(), requestDTO.getDeveloper(),
                requestDTO.getPublisher(), requestDTO.getPlatform(),requestDTO.getFeatures(), requestDTO.getPrice(), requestDTO.getDiscount(),
                requestDTO.getDescription());

    }

    @DeleteMapping("/delete/{name}")
    public void deleteGameEntry(@PathVariable String name){
        gameService.deleteGameEntry(name);
    }


}
