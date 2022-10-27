package com.fnd.games_store.cart.test.controller_integration_test;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fnd.games_store.cart.CartApplication;
import com.fnd.games_store.cart.dto.CartRequestDTO;
import com.fnd.games_store.cart.dto.CartResponseDTO;
import com.fnd.games_store.cart.entity.Game;
import com.fnd.games_store.cart.service.CartCrudService;
import com.fnd.games_store.cart.test.utilities.ControllerTestUtilities;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@SpringBootTest(classes = CartApplication.class)
@AutoConfigureMockMvc
public class GetCartContentTest extends ControllerTestUtilities {



    @Autowired
    private MockMvc mvc;

    @MockBean
    private CartCrudService service;


    @Test
    void test_getCartContent() throws Exception {

        MvcResult result = this.mvc.perform(post("/v1/update")
                                    .content(jsonCartRequestDTO(createAppropriateCartRequest(userId,testGameSet)))
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .accept(MediaType.APPLICATION_JSON))
                                    .andExpect(status().isOk())
                                    .andReturn();


        verify(service).updateCart(createAppropriateCartRequest(userId,testGameSet));
    }



    @BeforeEach
    void testSetup(){
        testGameSet.add(createTestGameEntity(1));

    }


    protected ObjectMapper objectMapper = new ObjectMapper();

    protected String userId = "user_1";

    protected Set<Game> testGameSet = new HashSet<>();




    protected String jsonCartRequestDTO(CartRequestDTO cartRequestDTO) {

        try {
            return objectMapper.writeValueAsString(createAppropriateCartRequest(cartRequestDTO.getUserId(), cartRequestDTO.getGameData()));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }



    protected CartRequestDTO createAppropriateCartRequest(String userId, Set<Game> gameData) {
            return new CartRequestDTO(userId, gameData);
        }

    protected CartResponseDTO createAppropriateCartResponse() {
        return new CartResponseDTO(userId,testGameSet);
    }


    protected Game createTestGameEntity(int differenceParameter){
        Game game = new Game();
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



