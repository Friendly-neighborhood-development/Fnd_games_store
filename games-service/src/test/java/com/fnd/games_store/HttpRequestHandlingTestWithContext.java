package com.fnd.games_store;


import com.fnd.games_store.games.GamesApplication;
import com.fnd.games_store.games.controller.GameController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = GamesApplication.class)
public class HttpRequestHandlingTestWithContext {

    @LocalServerPort
    private int port;


    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    GameController gameController;

    @Test
    void shouldBeReturnedDefaultMessage(){
        restTemplate.getForObject("http://localhost:"+ port + "/default",String.class).contains("Test succeed");

    }



}
