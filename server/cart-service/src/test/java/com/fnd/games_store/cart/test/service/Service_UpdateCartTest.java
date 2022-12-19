package com.fnd.games_store.cart.test.service;

import com.fnd.games_store.cart.dto.CartRequestDTO;
import com.fnd.games_store.cart.dto.CartResponseDTO;
import com.fnd.games_store.cart.test.utilities.ServiceTestUtilities;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Optional;
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class Service_UpdateCartTest extends ServiceTestUtilities {



    @Test
    void updateCartTest_ShouldReturnProperCart(){
        assertThat(service.updateCart(testCartRequest)).isEqualTo(testCartResponse);

        verify(repository).save(testCart);
        verify(repository).findById(userId);
    }



    protected CartRequestDTO testCartRequest = new CartRequestDTO();

    protected CartResponseDTO testCartResponse = new CartResponseDTO();


    @BeforeEach
    void testSetup(){

        testGameSet.add(createTestGameEntity(1));

        testCartRequest.setUserId(userId);
        testCartRequest.setGameData(testGameSet);

        testCartResponse.setUserId(userId);
        testCartResponse.setGameData(testGameSet);


        testCart.setUserId(userId);
        testCart.setGameData(testGameSet);

        when(repository.save(testCart)).thenReturn(testCart);
        when(repository.findById(userId)).thenReturn(Optional.ofNullable(testCart));

    }











    protected CartResponseDTO createTestCartResponseDTO(){
        return null;
    }








}
