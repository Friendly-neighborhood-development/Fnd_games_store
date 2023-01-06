package com.fnd.games_store.games.service;

import com.fnd.games_store.games.dto.game.GameResponseDTO;

public interface SpecificGameService {

    GameResponseDTO getGameByName(String name);

}
