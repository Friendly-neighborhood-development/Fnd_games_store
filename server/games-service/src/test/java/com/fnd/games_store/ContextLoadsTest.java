package com.fnd.games_store;

import com.fnd.games_store.games.GamesApplication;
import com.fnd.games_store.games.controller.GameController;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = GamesApplication.class)
public class ContextLoadsTest {

    @Autowired
    GameController controller;

    @Test
    void contextLoadsTest(){
        assertThat(controller).isNotNull();
    }
}
