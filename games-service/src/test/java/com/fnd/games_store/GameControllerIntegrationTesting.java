package com.fnd.games_store;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fnd.games_store.games.GamesApplication;
import com.fnd.games_store.games.controller.dto.GameResponseDTO;
import com.fnd.games_store.games.entity.Game;
import com.fnd.games_store.games.repository.GameRepository;
import com.fnd.games_store.games.service.GameService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.MvcResult;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@SpringBootTest(classes = GamesApplication.class)
@AutoConfigureMockMvc
public class GameControllerIntegrationTesting extends TestUtilities{

    @Autowired
    MockMvc mvc;


    @Autowired
    GameRepository gameRepository;

    @MockBean
    GameService gameService;




    @Test
    void test1() throws Exception {
        MvcResult requestResult = this.mvc.perform(post("/create").
                content(createGameRequest).
                contentType(MediaType.APPLICATION_JSON).
                accept(MediaType.APPLICATION_JSON)).
                andExpect(status().isOk()).
                andReturn();
        String body = requestResult.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        GameResponseDTO gameResponseDTO = objectMapper.readValue(body, GameResponseDTO.class);
        List <Game> createdDuringTestingGame = gameRepository.findAll();


        assertThat(createdDuringTestingGame.get(0).getName()).isEqualTo("name");








//        assertThat(gameResponseDTO.getName()).isEqualTo("name");
//        assertThat(gameResponseDTO.getGenre()).isEqualTo("genre");
//        assertThat(gameResponseDTO.getReleaseDate()).isEqualTo("date");
//        assertThat(gameResponseDTO.getDeveloper()).isEqualTo("developer");
//        assertThat(gameResponseDTO.getPublisher()).isEqualTo("publisher");
//        assertThat(gameResponseDTO.getPlatform()).isEqualTo("platform");
//        assertThat(gameResponseDTO.getFeatures()).isEqualTo("features");
//        assertThat(gameResponseDTO.getPrice().toBigInteger()).isEqualTo(1000);
//        assertThat(gameResponseDTO.getDiscount().toBigInteger()).isEqualTo(200);
//        assertThat(gameResponseDTO.getDescription()).isEqualTo(null);


    }


//    gameResponseDTO.setId("1");
//        gameResponseDTO.setName(null);
//        gameResponseDTO.setGenre(null);
//        gameResponseDTO.setReleaseDate("date");
//        gameResponseDTO.setDeveloper("developer");
//        gameResponseDTO.setPublisher("publisher");
//        gameResponseDTO.setPlatform("platform");
//        gameResponseDTO.setFeatures("features");
//        gameResponseDTO.setPrice(BigDecimal.valueOf(1000));
//        gameResponseDTO.setDiscount(BigDecimal.valueOf(200));
//        gameResponseDTO.setDescription("description");



    @BeforeEach
    private void createRequestIntegrationTestSetUp(){
        when(gameService.createGameEntry(ArgumentMatchers.any())).thenReturn(createAppropriateGameResponseDTO());
    }







}
