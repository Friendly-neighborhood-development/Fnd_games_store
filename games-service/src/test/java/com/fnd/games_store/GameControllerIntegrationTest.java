package com.fnd.games_store;


import com.fnd.games_store.games.GamesApplication;
import com.fnd.games_store.games.service.GameService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;

@SpringBootTest(classes = GamesApplication.class)
@AutoConfigureMockMvc
public class GameControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    GameService gameService;

    @Test
    void shouldReturnDefaultMessage(){
        when(gameService.defaultMessage()).thenReturn("Test succeed");
    }



}
