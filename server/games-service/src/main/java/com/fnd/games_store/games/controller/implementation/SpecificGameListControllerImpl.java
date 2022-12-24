package com.fnd.games_store.games.controller.implementation;


import com.fnd.games_store.games.controller.SpecificGameListController;
import com.fnd.games_store.games.dto.GameResponseDTO;
import com.fnd.games_store.games.service.GamePagingAndSortingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
public class SpecificGameListControllerImpl implements SpecificGameListController {


    private final GamePagingAndSortingService gameListService;

    @Autowired
    public SpecificGameListControllerImpl(GamePagingAndSortingService gameListService) {
        this.gameListService = gameListService;
    }

    @Override
    @GetMapping("v1/catalogue/specific")
    public ResponseEntity<List<GameResponseDTO>> getEditedList(){

        List<GameResponseDTO> list = gameListService.getAll();

        return ResponseEntity.ok(list);
    }


}
