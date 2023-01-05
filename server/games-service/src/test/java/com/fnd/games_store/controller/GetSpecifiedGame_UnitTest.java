package com.fnd.games_store.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fnd.games_store.games.GamesApplication;
import com.fnd.games_store.games.controller.implementation.SpecificGameControllerImpl;
import com.fnd.games_store.games.dto.game.GameResponseDTO;
import com.fnd.games_store.games.service.implementation.SpecificGameServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
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
public class GetSpecifiedGame_UnitTest {


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
