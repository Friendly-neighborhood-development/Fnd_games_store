package com.fnd.games_store.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fnd.games_store.games.GamesApplication;
import com.fnd.games_store.games.dto.game.GameResponseDTO;
import com.fnd.games_store.games.service.implementation.SpecificGameServiceImpl;
import lombok.extern.slf4j.Slf4j;
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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@SpringBootTest(classes = GamesApplication.class)
@AutoConfigureMockMvc
@Slf4j
public class GetSpecifiedGame {


    @Autowired
    private MockMvc mvc;

    @MockBean
    private SpecificGameServiceImpl service;


    private String gameName = "DOOM Eternal";

    private ObjectMapper objectMapper = new ObjectMapper();;

    @Test
    void getSpecificGame_ShouldReturnProperGameResponseObject() throws Exception {

        MvcResult requestResult = this.mvc.perform(get("/v1/catalogue/"+gameName)
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .accept(MediaType.APPLICATION_JSON))
                                    .andExpect(status().isOk()).andReturn();

        String requestBody = requestResult.getResponse().getContentAsString();

        GameResponseDTO actualResult = objectMapper.readValue(requestBody, GameResponseDTO.class);

        log.info(actualResult.toString());

        assertThat(actualResult).isEqualTo(createAppropriateGameResponseDTO());

    }


    @BeforeEach
    void testSetup(){

        when(service.getGameByName(gameName)).thenReturn(createAppropriateGameResponseDTO());

    }



    private GameResponseDTO createAppropriateGameResponseDTO() {

        GameResponseDTO returnableGame = new GameResponseDTO();

        returnableGame.setId("1");
        returnableGame.setName("DOOM Eternal");

        return returnableGame;
    }



}
