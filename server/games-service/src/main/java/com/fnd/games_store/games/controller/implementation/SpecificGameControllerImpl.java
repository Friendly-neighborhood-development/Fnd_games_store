package com.fnd.games_store.games.controller.implementation;

import com.fnd.games_store.games.controller.SpecificGameController;
import com.fnd.games_store.games.dto.game.GameResponseDTO;
import com.fnd.games_store.games.service.SpecificGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpecificGameControllerImpl implements SpecificGameController {



    private final SpecificGameService service;

    @Autowired
    public SpecificGameControllerImpl(SpecificGameService service) {
        this.service = service;
    }

    @Override
    @GetMapping("/v1/catalogue/{name}")
    public ResponseEntity<GameResponseDTO> getSpecifiedGame(@PathVariable String name) {
        return ResponseEntity.ok(service.getGameByName(name));
    }
}
