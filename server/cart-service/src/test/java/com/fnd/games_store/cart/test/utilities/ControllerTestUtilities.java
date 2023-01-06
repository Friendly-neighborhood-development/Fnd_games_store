package com.fnd.games_store.cart.test.utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fnd.games_store.cart.dto.CartRequestDTO;
import com.fnd.games_store.cart.dto.CartResponseDTO;
import com.fnd.games_store.cart.dto.GameRequestDTO;
import com.fnd.games_store.cart.dto.GameResponseDTO;
import com.fnd.games_store.cart.entity.Game;
import com.fnd.games_store.cart.rest.UserValidationClient;
import com.fnd.games_store.cart.service.CartCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ControllerTestUtilities {

    @Autowired
    protected MockMvc mvc;

    @MockBean
    protected UserValidationClient userValidationClient;
    @MockBean
    protected CartCrudService service;
    protected ObjectMapper objectMapper = new ObjectMapper();

    protected String userId = "user_1";

    protected List<GameResponseDTO> testGameResponse = new ArrayList<>();

    protected List<Game> testGameSet = new ArrayList<>();




    protected String jsonCartRequestDTO(CartRequestDTO cartRequestDTO) {

        try {
            return objectMapper.writeValueAsString(createAppropriateCartRequest(cartRequestDTO.getUserId(), cartRequestDTO.getGameData()));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }



    protected CartRequestDTO createAppropriateCartRequest(String userId, List<Game> gameData) {
        return new CartRequestDTO(userId, gameData);
    }

    protected CartResponseDTO createAppropriateCartResponse(String userId, List<Game> gameData) {
        return new CartResponseDTO(userId,gameData);
    }


    protected Game createTestGameEntity(int differenceParameter){
        Game game = new Game();
        game.setId("id"+ differenceParameter);
        game.setName("name" + differenceParameter);
        game.setGameUrl("url"+  differenceParameter);
        game.setReleaseDate("date" + differenceParameter);
        game.setPrice(BigDecimal.valueOf(1000));
        game.setDiscount(BigDecimal.valueOf(200));
        game.setDescription("description" + differenceParameter);
        game.setBase64Image("image" + differenceParameter);
        return game;
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

    protected GameResponseDTO createTestGameResponse(int differenceParameter){
        GameResponseDTO game = new GameResponseDTO();
        game.setId("id"+ differenceParameter);
        game.setName("name" + differenceParameter);
        game.setReleaseDate("date" + differenceParameter);
        game.setGameUrl("url"+ differenceParameter);
        game.setPrice(BigDecimal.valueOf(1000));
        game.setDiscount(BigDecimal.valueOf(200));
        game.setDescription("description" + differenceParameter);
        game.setBase64Image("image" + differenceParameter);
        return game;
    }
}
