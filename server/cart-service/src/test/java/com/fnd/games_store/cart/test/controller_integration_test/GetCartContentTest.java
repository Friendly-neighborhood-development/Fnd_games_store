package com.fnd.games_store.cart.test.controller_integration_test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fnd.games_store.cart.CartApplication;
import com.fnd.games_store.cart.dto.CartRequestDTO;
import com.fnd.games_store.cart.dto.GameRequestDTO;
import com.fnd.games_store.cart.dto.GameResponseDTO;
import com.fnd.games_store.cart.entity.Game;
import com.fnd.games_store.cart.service.CartCrudService;
import com.fnd.games_store.cart.test.utilities.ControllerTestUtilities;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;


import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest(classes = CartApplication.class)
@AutoConfigureMockMvc
public class GetCartContentTest {
    @Autowired
    protected MockMvc mvc;

    @MockBean
    protected CartCrudService service;
    protected ObjectMapper objectMapper = new ObjectMapper();

    protected String userId = "user_1";

    protected Set<Game> testGameSet = new HashSet<>();

    @Test
    void getCartContent_test() throws Exception {

        MvcResult result = this.mvc.perform(post("/v1/getContent")
                                .content(jsonGameRequestDTO(createAppropriateGameRequestDTO(userId)))
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                                .andExpect(status().isOk())
                                .andReturn();


        String body = result.getResponse().getContentAsString();

        GameResponseDTO response = new ObjectMapper().readValue(body, GameResponseDTO.class);

        assertThat(response).isEqualTo(new GameResponseDTO());


    }


    @BeforeEach
    void testSetup(){

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


}
