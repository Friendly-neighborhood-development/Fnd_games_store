package com.fnd.games_store.service;

import com.fnd.games_store.games.GamesApplication;
import com.fnd.games_store.games.dto.game.GameResponseDTO;
import com.fnd.games_store.games.repository.GameRepository;
import com.fnd.games_store.games.service.SpecificGameService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


import static org.assertj.core.api.Assertions.*;

@SpringBootTest(classes = GamesApplication.class)
@Slf4j
@Transactional
public class GetGameByName {


    @Autowired
    private SpecificGameService service;

    @Autowired
    private GameRepository repository;

    private GameResponseDTO serviceGameEntity;

    private GameResponseDTO controlGameEntity;

    private String controlGameName = "DOOM Eternal";


    @Test
    void getGameByName_ShouldReturnProperGameResponseDTO(){
        assertThat(serviceGameEntity).isEqualTo(controlGameEntity);
    }


    @BeforeEach
    void testSetup(){

        controlGameEntity = createAppropriateGameResponseDTO();

        serviceGameEntity = service.getGameByName(controlGameName);

    }

    private GameResponseDTO createAppropriateGameResponseDTO() {

        GameResponseDTO returnableGame = new GameResponseDTO(repository.getGameByName(controlGameName).get());

        return returnableGame;
    }

}
