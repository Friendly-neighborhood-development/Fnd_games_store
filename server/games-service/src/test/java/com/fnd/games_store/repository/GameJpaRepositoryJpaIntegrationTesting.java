package com.fnd.games_store.repository;


import com.fnd.games_store.games.GamesApplication;
import com.fnd.games_store.games.entity.Game;
import com.fnd.games_store.games.repository.GameJpaRepository;
import com.fnd.games_store.utilities.TestUtilities;
import org.junit.jupiter.api.BeforeEach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTestContextBootstrapper;
import org.springframework.test.context.BootstrapWith;



import static org.assertj.core.api.Assertions.*;


@DataJpaTest
@BootstrapWith(SpringBootTestContextBootstrapper.class)
@SpringBootTest(classes = GamesApplication.class)

public class GameJpaRepositoryJpaIntegrationTesting extends TestUtilities {

    @Autowired
    GameJpaRepository gameJpaRepository;

    @Autowired
    TestEntityManager testEntityManager;

    @Test
    void createdEntityShouldEqualsReturnedEntity(){
        Game returnedGameFromDb = gameJpaRepository.getGameByName("name");
        String returnedGameFromDbId = returnedGameFromDb.getId();
        assertThat(createTestGameEntity(returnedGameFromDbId)).isEqualTo(returnedGameFromDb);
    }


//      game.setName("name");
//        game.setGenre(null);
//        game.setReleaseDate("date");
//        game.setDeveloper("developer");
//        game.setPublisher("publisher");
//        game.setPlatform("platform");
//        game.setFeatures("features");
//        game.setPrice(BigDecimal.valueOf(1000));
//        game.setDiscount(BigDecimal.valueOf(200));
//        game.setDescription("description");



    @BeforeEach
    private void setUp(){
        Game testingGame = createTestGameEntity(null);
        testEntityManager.persist(testingGame);
        testEntityManager.flush();
    }



}
