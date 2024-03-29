package com.fnd.games_store.games.controller.implementation;


import com.fnd.games_store.games.controller.SpecificGameListController;
import com.fnd.games_store.games.dto.game.GameResponseDTO;
import com.fnd.games_store.games.service.SpecificGameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SpecificGameListControllerImpl implements SpecificGameListController {


    private final SpecificGameListService gameService;

    @Autowired
    public SpecificGameListControllerImpl(SpecificGameListService gameService) {
        this.gameService = gameService;
    }

    @Override
    @GetMapping("/v1/catalogue/list")
    public ResponseEntity<List<GameResponseDTO>> getEditedList(@RequestParam Integer page, @RequestParam Integer pageSize, @RequestParam String sortField, @RequestParam Boolean ascOrder) {
        if (ascOrder){
            return ResponseEntity.ok(gameService.getSpecifiedGameList(page,pageSize, Sort.by(sortField)));
        } else {
            return ResponseEntity.ok(gameService.getSpecifiedGameList(page,pageSize, Sort.by(Sort.Direction.DESC, sortField)));
        }
    }

}
