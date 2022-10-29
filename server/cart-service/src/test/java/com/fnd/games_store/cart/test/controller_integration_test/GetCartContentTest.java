package com.fnd.games_store.cart.test.controller_integration_test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fnd.games_store.cart.CartApplication;
import com.fnd.games_store.cart.dto.GameRequestDTO;
import com.fnd.games_store.cart.dto.GameResponseDTO;
import com.fnd.games_store.cart.service.CartCrudService;
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


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest(classes = CartApplication.class)
@AutoConfigureMockMvc
@Slf4j
public class GetCartContentTest {
    @Autowired
    protected MockMvc mvc;

    @MockBean
    protected CartCrudService service;
    protected ObjectMapper objectMapper = new ObjectMapper();

    protected String userId = "user_1";

    protected Set<GameResponseDTO> testGameResponse = new HashSet<>();

    protected Set<String> jsonGameResponseDTOSet = new HashSet<>();

    @Test
    void getCartContent_test() throws Exception {

        MvcResult result = this.mvc.perform(post("/v1/getContent")
                                .content(jsonGameRequestDTO(createAppropriateGameRequestDTO(userId)))
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                                .andExpect(status().isOk())
                                .andReturn();

        String body = result.getResponse().getContentAsString();

        Set<GameResponseDTO> response = objectMapper.readValue(body, HashSet.class);

//        log.info(response.toString());
//        log.info(testGameResponse.toString());
//        log.info("body: " + body);
//        log.info("getCartContent:" + service.getCartContent(userId));
//        log.info("jsonGameResponseDTO "+jsonGameResponseDTOSet);

        assertThat(response).isEqualTo(testGameResponse);

    }


    @BeforeEach
    void testSetup(){

        testGameResponse.add(createTestGameResponse(1));

        jsonGameResponseDTOSet.add(jsonGameResponseDTO(1));

        when(service.getCartContent(userId)).thenReturn(testGameResponse);

    }


    protected GameRequestDTO createAppropriateGameRequestDTO(String userId){
        return new GameRequestDTO(userId);
    }




    protected String jsonGameRequestDTO(GameRequestDTO gameRequestDTO) {

        try {
            return objectMapper.writeValueAsString(createAppropriateGameRequestDTO(gameRequestDTO.getUserId()));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }


    protected String jsonGameResponseDTO(int differenceParameter){
        try {
            return objectMapper.writeValueAsString(createTestGameResponse(differenceParameter));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }

    protected GameResponseDTO createTestGameResponse(int differenceParameter){
        GameResponseDTO game = new GameResponseDTO();
        game.setGameId("id"+ differenceParameter);
        game.setName("name" + differenceParameter);
        game.setGenre("genre" + differenceParameter);
        game.setReleaseDate("date" + differenceParameter);
        game.setDeveloper("developer" + differenceParameter);
        game.setPublisher("publisher" + differenceParameter);
        game.setPlatform("platform" + differenceParameter);
        game.setFeatures("features" + differenceParameter);
        game.setPrice(BigDecimal.valueOf(1000));
        game.setDiscount(BigDecimal.valueOf(200));
        game.setDescription("description" + differenceParameter);
        game.setBase64Image("image" + differenceParameter);
        return game;
    }
}
