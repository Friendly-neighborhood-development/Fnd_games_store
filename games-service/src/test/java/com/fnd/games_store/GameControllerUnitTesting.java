package com.fnd.games_store;


import com.fnd.games_store.games.controller.GameController;
import com.fnd.games_store.games.controller.dto.GameResponseDTO;
import com.fnd.games_store.games.service.GameService;
import org.jetbrains.annotations.NotNull;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class GameControllerUnitTesting {

    @Mock
    GameService gameService;

    @InjectMocks
    GameController gameController;

    @Test
    public void getMethodShouldReturnProperEntity(){
        setUpForGetMethodOfGameCOntroller();
        assertThat(gameService.getGameById("1").getName()).isEqualTo(gameController.getGameById("1").getName());
    }


    @Before
    private void setUpForGetMethodOfGameCOntroller(){
        when(gameService.getGameById(ArgumentMatchers.anyString())).thenReturn(createGameResponseDTO());
        when(gameController.getGameById(ArgumentMatchers.anyString())).thenReturn(createGameResponseDTO());
    }

    private @NotNull GameResponseDTO createGameResponseDTO(){
        GameResponseDTO gameResponseDTO =new GameResponseDTO();
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

}
