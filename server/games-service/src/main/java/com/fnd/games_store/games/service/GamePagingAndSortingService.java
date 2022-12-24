package com.fnd.games_store.games.service;

import com.fnd.games_store.games.dto.GameResponseDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface GamePagingAndSortingService {


    List<GameResponseDTO> getSpecifiedGameList(Integer pageNumber, Integer gamesOnPage);

    List<GameResponseDTO> getAll();

}
