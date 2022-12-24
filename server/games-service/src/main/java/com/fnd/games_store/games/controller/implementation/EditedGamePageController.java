package com.fnd.games_store.games.controller.implementation;


import com.fnd.games_store.games.controller.PagedAndSortedGameList;
import com.fnd.games_store.games.dto.GameResponseDTO;
import com.fnd.games_store.games.service.GameCataloguePagerAndSorter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EditedGamePageController implements PagedAndSortedGameList {


    private final GameCataloguePagerAndSorter gameListService;

    @Autowired
    public EditedGamePageController(GameCataloguePagerAndSorter gameListService) {
        this.gameListService = gameListService;
    }


    @GetMapping("v1/catalogue/specific")
    public ResponseEntity<List<GameResponseDTO>> getEditedList(){

        List<GameResponseDTO> list = gameListService.getAll();

        return ResponseEntity.ok(list);
    }


}
