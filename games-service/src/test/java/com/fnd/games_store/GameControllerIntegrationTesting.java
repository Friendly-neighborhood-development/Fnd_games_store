package com.fnd.games_store;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fnd.games_store.games.GamesApplication;
import com.fnd.games_store.games.controller.dto.GameResponseDTO;
import com.fnd.games_store.games.service.GameService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.MvcResult;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@SpringBootTest(classes = GamesApplication.class)
@AutoConfigureMockMvc
public class GameControllerIntegrationTesting extends TestUtilities{

    @Autowired
    MockMvc mvc;


    @MockBean
    GameService gameService;




    @Test
    void test1() throws Exception {



        MvcResult requestResult = this.mvc.perform(post("/create").
                content(createGameControllerRequest(createAppropriateGameRequestDTO())).
                contentType(MediaType.APPLICATION_JSON).
                accept(MediaType.APPLICATION_JSON)).
                andExpect(status().isOk()).
                andReturn();
        String body = requestResult.getResponse().getContentAsString();
        GameResponseDTO gameResponseDTO = new ObjectMapper().readValue(body, GameResponseDTO.class);
        assertThat(gameResponseDTO).isEqualTo(createAppropriateGameResponseDTO());


    }


    @BeforeEach
    private void createRequestIntegrationTestSetUp(){
        when(gameService.createGameEntry(createAppropriateGameRequestDTO()))
                .thenReturn(createCustomGameResponseDTO(createAppropriateGameRequestDTO()));
    }


}
