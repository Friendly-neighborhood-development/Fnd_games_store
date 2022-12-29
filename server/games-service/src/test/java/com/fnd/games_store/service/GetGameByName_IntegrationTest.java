package com.fnd.games_store.service;

import com.fnd.games_store.games.GamesApplication;
import com.fnd.games_store.games.dto.GameResponseDTO;
import com.fnd.games_store.games.entity.Game;
import com.fnd.games_store.games.repository.GameRepository;
import com.fnd.games_store.games.service.GamePagingAndSortingService;
import com.fnd.games_store.games.service.implementation.GamePagingAndSortingServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTestContextBootstrapper;
import org.springframework.test.context.BootstrapWith;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.*;



@SpringBootTest(classes = GamesApplication.class)
@Slf4j
public class GetGameByName_IntegrationTest {


//    @Autowired
//    private GameRepository repository;
//
//    private Game referenceGame;
//
//    private String referenceGameName = "DOOM Eternal";
//
//
//    @Test
//    void getGameByName_ShouldReturnProperGameResponseDTO(){
//
//
////        Session session = Session.getSession();
//
//
//        assertThat(referenceGame).isEqualTo(createAppropriateGameResponseDTO());
//    }
//
//
//    private Game createAppropriateGameResponseDTO() {
//        Game returnableGame = new Game();
//        returnableGame.setId("1");
//        returnableGame.setName("Doom Eternal");
//        returnableGame.setReleaseDate("2019");
//        returnableGame.setDeveloper(null);
//        returnableGame.setPublisher(null);
//
//
//
////        '1','DOOM Eternal', '2019', '1','1', 1500.64, 15.2,
//        return returnableGame;
//    }
//
//    //    private List<GameResponseDTO> referenceList;
////
////    private Integer page = 0;
////
////    private Integer pageSize = 2;
////
////    private String sortField = "name";
////    private Sort sortBy = Sort.by(sortField);
//
//    //        referenceList = repository.findAll(PageRequest.of(page,pageSize, sortBy)).stream().map(GameResponseDTO::new).collect(Collectors.toList());





}
