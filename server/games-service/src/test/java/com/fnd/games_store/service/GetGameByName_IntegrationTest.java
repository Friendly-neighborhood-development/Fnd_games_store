package com.fnd.games_store.service;

import com.fnd.games_store.games.GamesApplication;
import com.fnd.games_store.games.dto.GameResponseDTO;
import com.fnd.games_store.games.entity.Game;
import com.fnd.games_store.games.repository.GameRepository;
import com.fnd.games_store.games.service.GamePagingAndSortingService;
import com.fnd.games_store.games.service.implementation.GamePagingAndSortingServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTestContextBootstrapper;
import org.springframework.test.context.BootstrapWith;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest(classes = GamesApplication.class)
@Slf4j
public class GetGameByName_IntegrationTest {


    @Autowired
    private GameRepository repository;

    @Autowired
    private GamePagingAndSortingServiceImpl testableService;

    private GameResponseDTO referenceGame;

    private String referenceGameName = "DOOM Eternal";


    @Test
    void getGameByName_ShouldReturnProperGameResponseDTO(){
        assertThat(referenceGame).isEqualTo(createAppropriateGameResponseDTO());
    }

    @BeforeEach
    void testSetup(){

//        Game gameFromDb = repository.getGameByName(referenceGameName);
//        log.info(gameFromDb.getName());
        referenceGame = new GameResponseDTO(repository.getGameByName(referenceGameName));
//        referenceGame.setId("1");
//        referenceGame.setBase64Image("");
//        referenceGame.setDescription("");
    }




    private GameResponseDTO createAppropriateGameResponseDTO() {
        GameResponseDTO returnableGame = new GameResponseDTO();
        returnableGame.setId("1");
        returnableGame.setName("Doom Eternal");
        returnableGame.setReleaseDate("2019");
        returnableGame.setDeveloper(null);
        returnableGame.setPublisher(null);



//        '1','DOOM Eternal', '2019', '1','1', 1500.64, 15.2,
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
