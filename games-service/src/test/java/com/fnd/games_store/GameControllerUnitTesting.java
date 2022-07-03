package com.fnd.games_store;


import com.fnd.games_store.games.controller.GameController;
import com.fnd.games_store.games.controller.dto.GameRequestDTO;
import com.fnd.games_store.games.controller.dto.GameResponseDTO;
import com.fnd.games_store.games.exceptions.GameNotFoundException;
import com.fnd.games_store.games.service.GameService;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class GameControllerUnitTesting {

    @Mock
    GameService gameService;

    @InjectMocks
    GameController gameController;

    @Test
    void getMethodShouldReturnProperObject() {
        getMethodMockSetUp();
        assertThat(gameService.getGameById("1")).isEqualTo(gameController.getGameById("1"));
    }

    @Test
    void getMethodShouldThrowException() {
        getMethodMockSetUpException();
        Exception e = assertThrows(GameNotFoundException.class, ()->{
            gameController.getGameById("2");
        });
        assertEquals("Requested game not found",e.getMessage());
    }

    @Test
    void getGamesCatalogueMethodShouldReturnListOfProperObjects(){
        getGameCatalogueMethodMockSetUp();
        for(GameResponseDTO i : createGameResponseDTOList()){
            assertThat(gameService.getGamesCatalogue()).isEqualTo(gameController.getGameCatalogue());
        }
    }
    @Test
    void createMethodShouldCreateProperObject(){
        createMethodMockSetUp();
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


    private @NotNull GameResponseDTO createAppropriateGameResponseDTO(){
        GameResponseDTO gameResponseDTO = new GameResponseDTO();
        gameResponseDTO.setId("1");
        gameResponseDTO.setName("name");
        gameResponseDTO.setGenre("genre");
        gameResponseDTO.setReleaseDate("date");
        gameResponseDTO.setDeveloper("developer");
        gameResponseDTO.setPublisher("publisher");
        gameResponseDTO.setPlatform("platform");
        gameResponseDTO.setFeatures("features");
        gameResponseDTO.setPrice(BigDecimal.valueOf(1000));
        gameResponseDTO.setDiscount(BigDecimal.valueOf(200));
        gameResponseDTO.setDescription("description");
        return gameResponseDTO;
    }

    private @NotNull List<GameResponseDTO> createGameResponseDTOList(){
        List<GameResponseDTO> list = new ArrayList<>();
        list.add(createAppropriateGameResponseDTO());
        list.add(createAppropriateGameResponseDTO());
        return list;
    }

    private @NotNull GameResponseDTO createNotAppropriateGameResponseDTO(){
        GameResponseDTO gameResponseDTO = new GameResponseDTO();
        gameResponseDTO.setId("1");
        gameResponseDTO.setName(null);
        gameResponseDTO.setGenre(null);
        gameResponseDTO.setReleaseDate("date");
        gameResponseDTO.setDeveloper("developer");
        gameResponseDTO.setPublisher("publisher");
        gameResponseDTO.setPlatform("platform");
        gameResponseDTO.setFeatures("features");
        gameResponseDTO.setPrice(BigDecimal.valueOf(1000));
        gameResponseDTO.setDiscount(BigDecimal.valueOf(200));
        gameResponseDTO.setDescription("description");
        return gameResponseDTO;
    }

    private @NotNull GameRequestDTO createAppropriateGameRequestDTO(){
        GameRequestDTO gameRequestDTO = new GameRequestDTO();
        gameRequestDTO.setId("1");
        gameRequestDTO.setName("name");
        gameRequestDTO.setGenre("genre");
        gameRequestDTO.setReleaseDate("date");
        gameRequestDTO.setDeveloper("developer");
        gameRequestDTO.setPublisher("publisher");
        gameRequestDTO.setPlatform("platform");
        gameRequestDTO.setFeatures("features");
        gameRequestDTO.setPrice(BigDecimal.valueOf(1000));
        gameRequestDTO.setDiscount(BigDecimal.valueOf(200));
        gameRequestDTO.setDescription("description");
        return gameRequestDTO;
    }
}
