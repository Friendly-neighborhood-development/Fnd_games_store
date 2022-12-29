package com.fnd.games_store.games.controller;

import com.fnd.games_store.games.dto.GameResponseDTO;
import org.springframework.http.ResponseEntity;

public interface SpecificGameController {

    ResponseEntity<GameResponseDTO> getSpecifiedGame(String name);


}
