package com.fnd.games_store.service;


import com.fnd.games_store.utilities.TestUtilities;
import com.fnd.games_store.games.controller.GameController;

import com.fnd.games_store.games.controller.dto.GameResponseDTO;
import com.fnd.games_store.games.exceptions.GameNotFoundException;
import com.fnd.games_store.games.service.GameService;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
// TODO refactor this tests as service layer tests
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class GameControllerUnitTesting extends TestUtilities {

    @Mock
    private GameService gameService;

    @InjectMocks
    private GameController gameController;

    @Test
    void getMethodShouldReturnProperObject() {
        assertThat(gameService.getGameById("1")).isEqualTo(gameController.getGameById("1"));
    }

    @Test
    void getMethodShouldThrowException() {
        Exception e = assertThrows(GameNotFoundException.class, ()->{
            gameController.getGameById("2");
        });
        assertEquals("Requested game not found",e.getMessage());
    }

    @Test
    void getGamesCatalogueMethodShouldReturnListOfProperObjects(){
        for(GameResponseDTO i : createGameResponseDTOList()){
            assertThat(gameService.getGamesCatalogue()).isEqualTo(gameController.getGameCatalogue());
        }
    }
    @Test
    void createMethodShouldCreateProperObject(){
        assertThat(gameService.createGameEntry(createAppropriateGameRequestDTO())).isEqualTo(createAppropriateGameResponseDTO());
    }


    @BeforeEach
    private void getMethodMockSetUp(){
        when(gameService.getGameById(ArgumentMatchers.anyString())).thenReturn(createAppropriateGameResponseDTO());
    }

    @BeforeEach
    private void getGameCatalogueMethodMockSetUp(){
        when(gameService.getGamesCatalogue()).thenReturn(createGameResponseDTOList());
    }

    @BeforeEach
    private void getMethodMockSetUpException(){
        when(gameService.getGameById(ArgumentMatchers.matches("2"))).thenThrow(new GameNotFoundException());
    }

    @BeforeEach
    private void createMethodMockSetUp(){
        when(gameService.createGameEntry(ArgumentMatchers.any())).thenReturn(createAppropriateGameResponseDTO());
    }



}
