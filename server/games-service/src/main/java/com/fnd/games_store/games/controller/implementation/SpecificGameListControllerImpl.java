package com.fnd.games_store.games.controller.implementation;


import com.fnd.games_store.games.controller.SpecificGameListController;
import com.fnd.games_store.games.dto.GameResponseDTO;
import com.fnd.games_store.games.service.GamePagingAndSortingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SpecificGameListControllerImpl implements SpecificGameListController {


    private final GamePagingAndSortingService gameService;

    @Autowired
    public SpecificGameListControllerImpl(GamePagingAndSortingService gameService) {
        this.gameService = gameService;
    }

    @Override
    @GetMapping("v1/catalogue/edited")
    public ResponseEntity<List<GameResponseDTO>> getEditedList(@RequestParam Integer page, @RequestParam Integer pageSize) {
        return ResponseEntity.ok(gameService.getSpecifiedGameList(page,pageSize));
    }

    @Override
    @GetMapping("v1/catalogue/all")
    public ResponseEntity<List<GameResponseDTO>> getUnEditedList(){
        return ResponseEntity.ok(gameService.getAll());
    }


}
