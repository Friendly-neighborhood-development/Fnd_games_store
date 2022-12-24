package com.fnd.games_store.games.service;

import com.fnd.games_store.games.dto.GameResponseDTO;

import java.util.List;

public interface GamePagingAndSortingService {


    GameResponseDTO getSpecifiedGameList();

    List<GameResponseDTO> getAll();

}
