package com.fnd.games_store.cart.test.service;

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


import static org.mockito.Mockito.doReturn;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class UpdateCartTest extends ServiceTestUtilities {



    @Mock
    private CartRepository repository;


    @InjectMocks
    private CartService service;



    @Test
    void testing() {
        assertThat(service.updateCart(testRequestCart)).isNull();
    }


    @BeforeEach
    void testSetup(){

//        testCart.setUserId(userId);
//        testCart.setGameId(gameId);
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


}
