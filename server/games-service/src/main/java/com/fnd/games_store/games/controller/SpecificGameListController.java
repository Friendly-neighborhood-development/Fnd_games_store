package com.fnd.games_store.games.controller;

import com.fnd.games_store.games.dto.GameResponseDTO;
import net.bytebuddy.TypeCache;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SpecificGameListController {

    ResponseEntity<List<GameResponseDTO>> getEditedList(Integer page, Integer pageSize,  String sortField, Boolean descOrder);

    ResponseEntity<List<GameResponseDTO>> getUnEditedList();
}
