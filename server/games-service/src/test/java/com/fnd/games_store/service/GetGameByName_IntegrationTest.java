package com.fnd.games_store.service;

import com.fnd.games_store.games.GamesApplication;
import com.fnd.games_store.games.dto.game.GameResponseDTO;
import com.fnd.games_store.games.service.SpecificGameService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest(classes = GamesApplication.class)
@Slf4j
public class GetGameByName_IntegrationTest {


    @Autowired
    private SpecificGameService service;

    private GameResponseDTO serviceGameEntity;

    private GameResponseDTO controlGameEntity;

    private String controlGameName = "Grand Theft Auto V";


    @Test
    void getGameByName_ShouldReturnProperGameResponseDTO(){
        assertThat(service.getGameByName(controlGameName)).isEqualTo(controlGameEntity);
    }


    @BeforeEach
    void testSetup(){


        this.controlGameEntity = createAppropriateGameResponseDTO();


    }

    private GameResponseDTO createAppropriateGameResponseDTO() {
        GameResponseDTO returnableGame = new GameResponseDTO();
        returnableGame.setId("1");
        returnableGame.setName("Doom Eternal");
        returnableGame.setReleaseDate("2019");
        returnableGame.setDeveloper(null);
        returnableGame.setPublisher(null);



        return returnableGame;
    }

    //    private List<GameResponseDTO> referenceList;
//
//    private Integer page = 0;
//
//    private Integer pageSize = 2;
//
//    private String sortField = "name";
//    private Sort sortBy = Sort.by(sortField);

    //        referenceList = repository.findAll(PageRequest.of(page,pageSize, sortBy)).stream().map(GameResponseDTO::new).collect(Collectors.toList());





}
