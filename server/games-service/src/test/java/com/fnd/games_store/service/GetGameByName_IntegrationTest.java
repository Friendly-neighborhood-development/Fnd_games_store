package com.fnd.games_store.service;

import com.fnd.games_store.games.dto.GameResponseDTO;
import com.fnd.games_store.games.repository.GameRepository;
import org.junit.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTestContextBootstrapper;
import org.springframework.test.context.BootstrapWith;

@SpringBootTest
@DataJpaTest
@BootstrapWith(SpringBootTestContextBootstrapper.class)
public class GetGameByName_IntegrationTest {



    private GameRepository repository;



    @Test
    void getGameByName_ShouldReturnProperGameResponseDTO(){

    }


    private GameResponseDTO createAppropriateGameResponseDTO() {
        GameResponseDTO returnableGame = new GameResponseDTO();
        returnableGame.setName("Doom Eternal");

        return returnableGame;
    }

}
