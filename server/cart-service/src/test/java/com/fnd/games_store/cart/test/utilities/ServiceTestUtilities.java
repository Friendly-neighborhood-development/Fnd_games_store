package com.fnd.games_store.cart.test.utilities;

import com.fnd.games_store.cart.dto.GameResponseDTO;
import com.fnd.games_store.cart.entity.Cart;
import com.fnd.games_store.cart.entity.Game;
import com.fnd.games_store.cart.repository.CartRepository;
import com.fnd.games_store.cart.service.implementation.CartService;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ServiceTestUtilities {

    @Mock
    protected CartRepository repository;

    @InjectMocks
    protected CartService service;


    protected List<Game> testGameSet = new ArrayList<>();

    protected List<GameResponseDTO> testGameSetDTO = new ArrayList<>();
    protected String userId = "user_1";


    protected Cart testCart = new Cart();



    protected ServiceTestUtilities() {

    }





    protected Game createTestGameEntity(int differenceParameter){
        Game game = new Game();
        game.setId("id"+ differenceParameter);
        game.setName("name" + differenceParameter);
        game.setReleaseDate("date" + differenceParameter);
        game.setGameUrl("url" + differenceParameter);
        game.setPrice(BigDecimal.valueOf(1000));
        game.setDiscount(BigDecimal.valueOf(200));
        game.setDescription("description" + differenceParameter);
        game.setBase64Image("image" + differenceParameter);
        return game;
    }


    protected GameResponseDTO createTestGameResponse(int differenceParameter){
        GameResponseDTO game = new GameResponseDTO();
        game.setId("id"+ differenceParameter);
        game.setName("name" + differenceParameter);
        game.setReleaseDate("date" + differenceParameter);
        game.setGameUrl("url" + differenceParameter);
        game.setPrice(BigDecimal.valueOf(1000));
        game.setDiscount(BigDecimal.valueOf(200));
        game.setDescription("description" + differenceParameter);
        game.setBase64Image("image" + differenceParameter);
        return game;
    }


}
