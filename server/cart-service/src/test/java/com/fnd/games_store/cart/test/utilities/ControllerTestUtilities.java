package com.fnd.games_store.cart.test.utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fnd.games_store.cart.dto.CartRequestDTO;
import com.fnd.games_store.cart.dto.CartResponseDTO;
import com.fnd.games_store.cart.entity.Game;
import com.fnd.games_store.cart.service.CartCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class ControllerTestUtilities {



    @Autowired
    protected MockMvc mvc;

    @MockBean
    protected CartCrudService service;

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

    protected CartResponseDTO createAppropriateCartResponse(String userId, Set<Game> gameData) {
        return new CartResponseDTO(userId,gameData);
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
