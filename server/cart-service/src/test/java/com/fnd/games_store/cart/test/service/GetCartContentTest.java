package com.fnd.games_store.cart.test.service;


import com.fnd.games_store.cart.test.utilities.ServiceTestUtilities;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Optional;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class GetCartContentTest extends ServiceTestUtilities {




    @Test
    void getCartContent_ShouldReturnProperCartData() {

        assertThat(service.getCartContent(userId)).isEqualTo(testGameSetDTO);

        verify(repository).findById(userId);

    }


    @BeforeEach
    void testSetup(){

        testCart.setUserId(userId);
        testGameSet.add(createTestGameEntity(1));
        testCart.setGameData(testGameSet);

        testGameSetDTO.add(createTestGameResponse(1));


        when(repository.findById(userId)).thenReturn(Optional.ofNullable(testCart));
    }




}
