package com.fnd.games_store;

import com.fnd.games_store.games.controller.dto.GameRequestDTO;
import com.fnd.games_store.games.controller.dto.GameResponseDTO;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TestUtilities {


    protected final String getGameRequest =
            "{"+"\"name\": \"gta5\""+"}";



    protected final String getGameCatalogueRequest = "";

    protected final String createGameRequest = "{"+"" +
            "\"name\": \"gta5\""






            +"}";

    protected final String updateGameRequest = "";

    protected final String deleteGameRequest = "";


    protected TestUtilities(){

    }

    protected @NotNull GameResponseDTO createAppropriateGameResponseDTO(){
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

    protected @NotNull List<GameResponseDTO> createGameResponseDTOList(){
        List<GameResponseDTO> list = new ArrayList<>();
        list.add(createAppropriateGameResponseDTO());
        list.add(createAppropriateGameResponseDTO());
        return list;
    }

    protected @NotNull GameResponseDTO createNotAppropriateGameResponseDTO(){
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

    protected @NotNull GameRequestDTO createAppropriateGameRequestDTO(){
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
