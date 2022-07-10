package com.fnd.games_store.repository;


import com.fnd.games_store.games.GamesApplication;
import com.fnd.games_store.games.entity.Game;
import com.fnd.games_store.games.repository.GameRepository;
import com.fnd.games_store.utilities.TestUtilities;
import org.junit.jupiter.api.BeforeEach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTestContextBootstrapper;
import org.springframework.test.context.BootstrapWith;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


@DataJpaTest
@BootstrapWith(SpringBootTestContextBootstrapper.class)
@SpringBootTest(classes = GamesApplication.class)

public class GameRepositoryJpaIntegrationTesting extends TestUtilities {

    @Autowired
    GameRepository gameRepository;

    @Autowired
    TestEntityManager testEntityManager;

    @Test
    void createdEntityShouldEqualsReturnedEntity(){
        List<Game> returnedGame = gameRepository.findAll();
        createTestGameEntity().setId(returnedGame.get(0).getId());
        assertThat(createTestGameEntity()).isEqualTo(returnedGame.get(0));
    }



    @BeforeEach
    private void setUp(){
        Game testingGame = createTestGameEntity();
        testEntityManager.persist(testingGame);
        testEntityManager.flush();
    }



}
