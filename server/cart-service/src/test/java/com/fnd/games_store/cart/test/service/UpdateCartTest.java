package com.fnd.games_store.cart.test.service;

import com.fnd.games_store.cart.dto.CartRequestDTO;
import com.fnd.games_store.cart.dto.CartResponseDTO;
import com.fnd.games_store.cart.dto.GameResponseDTO;
import com.fnd.games_store.cart.entity.Cart;
import com.fnd.games_store.cart.entity.Game;
import com.fnd.games_store.cart.repository.CartRepository;
import com.fnd.games_store.cart.service.implementation.CartService;
import com.fnd.games_store.cart.test.utilities.ServiceTestUtilities;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.doReturn;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class UpdateCartTest extends ServiceTestUtilities {



    @Mock
    private CartRepository repository;


    @InjectMocks
    private CartService service;


    protected String userId = "user_1";

    protected Set<GameResponseDTO> testGameList = new HashSet<>();

    protected CartRequestDTO testRequest = new CartRequestDTO();

    protected CartResponseDTO testResponse = new CartResponseDTO();

    protected Cart testCart = new Cart();

    @Test
    void testing() {
//        assertThat(service.updateCart(testRequestCart)).isNull();
    }


    @BeforeEach
    void testSetup(){

//        testCart.setUserId(userId);
//        testGameList.add(createTestGameData("1"));
//        testCart.setGameData(testGameList);
//
//        when(repository.findById(userId).get()).thenReturn();



    }


//    public CartResponseDTO updateCart(CartRequestDTO incomingCartData) {
//        Cart updatingCart = new Cart();
//        updatingCart.setUserId(incomingCartData.getUserId());
//        updatingCart.setGameData(incomingCartData.getGameData());
//
//        repository.save(updatingCart);
//
//        return new CartResponseDTO(incomingCartData);


    CartRequestDTO createRequest(){

        testRequest.setUserId(userId);

        return testRequest;
    }


//    protected CartResponseDTO createTestRequest(){
//
//    }


    protected GameResponseDTO createTestGameData(String differenceParameter){
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


//        testCart.setUserId(userId);
//        testCart.setGameData(createTestGameEntity("1"));
//
//
//        testGameList.add(createTestGameEntity("1"));
//
//        when(repository.getCartContent(userId)).thenReturn(testGameList);
//
//        doReturn(testGameList).when(repository).updateCart(testResponseCart);
//
//        doReturn(null).when(repository).deleteGameEntry(userId,gameId);
}
