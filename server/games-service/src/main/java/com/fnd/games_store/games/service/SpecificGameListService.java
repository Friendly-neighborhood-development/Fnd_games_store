package com.fnd.games_store.games.service;

import com.fnd.games_store.games.dto.game.GameResponseDTO;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface SpecificGameListService {


    List<GameResponseDTO> getSpecifiedGameList(Integer pageNumber, Integer gamesOnPage, Sort sortBy);




}
