package com.fnd.games_store.service;

import com.fnd.games_store.games.dto.GameResponseDTO;
import com.fnd.games_store.games.repository.GameRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTestContextBootstrapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.BootstrapWith;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
@DataJpaTest
@BootstrapWith(SpringBootTestContextBootstrapper.class)
public class GetGameByName_IntegrationTest {



    private GameRepository repository;

    private List<GameResponseDTO> referenceList;

    private Integer page = 0;

    private Integer pageSize = 2;

    private String sortField = "name";
    private Sort sortBy = Sort.by(sortField);


    @Test
    void getGameByName_ShouldReturnProperGameResponseDTO(){

    }

    @BeforeEach
    void testSetup(){
        referenceList = repository.findAll(PageRequest.of(page,pageSize, sortBy)).stream().map(GameResponseDTO::new).collect(Collectors.toList());
    }




    private GameResponseDTO createAppropriateGameResponseDTO() {
        GameResponseDTO returnableGame = new GameResponseDTO();
        returnableGame.setName("Doom Eternal");

        return returnableGame;
    }

}
