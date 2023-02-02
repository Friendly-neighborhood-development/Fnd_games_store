package com.fnd.games_store.service;


import com.fnd.games_store.games.GamesApplication;
import com.fnd.games_store.games.dto.game.GameResponseDTO;
import com.fnd.games_store.games.repository.GameRepository;
import com.fnd.games_store.games.service.SpecificGameListService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


import static org.assertj.core.api.Assertions.*;

@SpringBootTest(classes = GamesApplication.class)
@Transactional
public class GetSpecifiedGameList {


    @Autowired
    private GameRepository repository;

    @Autowired
    private SpecificGameListService service;

    private Integer page = 0;
    private Integer pageSize = 2;
    private String sortField = "name";
    private Sort sortBy = Sort.by(sortField);

    private List<GameResponseDTO> loadedGameListFromDB;

    private List<GameResponseDTO> serviceGameList;


    @Test
    void getSpecifiedGameList_ShouldReturnProperGamesList() {

        assertThat(serviceGameList).isEqualTo(loadedGameListFromDB);

    }


    @BeforeEach
    void testSetup(){

        loadedGameListFromDB = loadGamesListFromDB();
        serviceGameList = service.getSpecifiedGameList(page,pageSize, sortBy);
    }


    private List<GameResponseDTO> loadGamesListFromDB(){

        return repository.findAll(PageRequest.of(page,pageSize, sortBy)).stream().map(GameResponseDTO::new).collect(Collectors.toList());

    }


}
