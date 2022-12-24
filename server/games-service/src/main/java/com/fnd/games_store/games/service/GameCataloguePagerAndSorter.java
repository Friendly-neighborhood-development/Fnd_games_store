package com.fnd.games_store.games.service;

import com.fnd.games_store.games.dto.GameResponseDTO;
import com.fnd.games_store.games.entity.Game;

import java.util.List;

public interface GameCataloguePagerAndSorter {


    GameResponseDTO getSpecifiedGameList();

    List<GameResponseDTO> getAll();

}
