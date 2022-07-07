package com.fnd.games_store;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fnd.games_store.games.GamesApplication;
import com.fnd.games_store.games.controller.GameController;
import com.fnd.games_store.games.controller.dto.GameResponseDTO;
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
    GameController gameController;


    @Test
    void test1() throws Exception {
        createRequestIntegrationTestSetUp();
        MvcResult requestResult = this.mvc.perform(post("/create").
                content(createGameRequest).
                contentType(MediaType.APPLICATION_JSON).
                accept(MediaType.APPLICATION_JSON)).
                andExpect(status().isOk()).
                andReturn();
        String body = requestResult.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        GameResponseDTO gameResponseDTO = objectMapper.readValue(body, GameResponseDTO.class);
        assertThat(gameResponseDTO.getName()).isEqualTo("name");
    }

    @BeforeEach
    private void createRequestIntegrationTestSetUp(){
        when(gameController.createGameEntry(ArgumentMatchers.any())).thenReturn(createAppropriateGameResponseDTO());
    }







}
