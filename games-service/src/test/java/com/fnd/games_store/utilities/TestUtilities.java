package com.fnd.games_store.utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fnd.games_store.games.controller.dto.GameRequestDTO;
import com.fnd.games_store.games.controller.dto.GameResponseDTO;
import com.fnd.games_store.games.entity.Game;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TestUtilities {

    private ObjectMapper objectMapper = new ObjectMapper();


    protected final String getGameRequest =
            "{"+"\"name\": \"gta5\""+"}";



    protected final String getGameCatalogueRequest = "";

    protected final String updateGameRequest = "";

    protected final String deleteGameRequest = "";


    protected TestUtilities(){

    }



    protected @NotNull String createGameControllerRequest(GameRequestDTO gameRequestDTO) {
        createCustomGameResponseDTO(gameRequestDTO);
        try{
            return objectMapper.writeValueAsString(createAppropriateGameResponseDTO());
        } catch (JsonProcessingException e){
            e.printStackTrace();
            return "";
        }
    }

    protected @NotNull GameResponseDTO createCustomGameResponseDTO(GameRequestDTO gameRequestDTO){
        GameResponseDTO gameResponseDTO = new GameResponseDTO();
        gameResponseDTO.setId(gameRequestDTO.getId());
        gameResponseDTO.setName(gameRequestDTO.getName());
        gameResponseDTO.setGenre(gameRequestDTO.getGenre());
        gameResponseDTO.setReleaseDate(gameRequestDTO.getReleaseDate());
        gameResponseDTO.setDeveloper(gameRequestDTO.getDeveloper());
        gameResponseDTO.setPublisher(gameRequestDTO.getPublisher());
        gameResponseDTO.setPlatform(gameRequestDTO.getPlatform());
        gameResponseDTO.setFeatures(gameRequestDTO.getFeatures());
        gameResponseDTO.setPrice(gameRequestDTO.getPrice());
        gameResponseDTO.setDiscount(gameRequestDTO.getDiscount());
        gameResponseDTO.setDescription(gameRequestDTO.getDescription());
        gameResponseDTO.setBase64Image(gameRequestDTO.getBase64Image());
        return gameResponseDTO;
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
        gameResponseDTO.setBase64Image("image");
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
        gameResponseDTO.setBase64Image("image");
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
        gameRequestDTO.setBase64Image("image");
        return gameRequestDTO;
    }

    protected @NotNull GameRequestDTO createNotAppropriateGameRequestDTO(){
        GameRequestDTO gameRequestDTO = new GameRequestDTO();
        gameRequestDTO.setId("1");
        gameRequestDTO.setName(null);
        gameRequestDTO.setGenre(null);
        gameRequestDTO.setReleaseDate("date");
        gameRequestDTO.setDeveloper("developer");
        gameRequestDTO.setPublisher("publisher");
        gameRequestDTO.setPlatform("platform");
        gameRequestDTO.setFeatures("features");
        gameRequestDTO.setPrice(BigDecimal.valueOf(1000));
        gameRequestDTO.setDiscount(BigDecimal.valueOf(200));
        gameRequestDTO.setDescription("description");
        gameRequestDTO.setBase64Image("image");
        return gameRequestDTO;
    }

    protected Game createTestGameEntity(String id){
        Game game = new Game();
        game.setId(id);
        game.setName("name");
        game.setGenre(null);
        game.setReleaseDate("date");
        game.setDeveloper("developer");
        game.setPublisher("publisher");
        game.setPlatform("platform");
        game.setFeatures("features");
        game.setPrice(BigDecimal.valueOf(1000));
        game.setDiscount(BigDecimal.valueOf(200));
        game.setDescription("description");
        game.setBase64Image("image");
        return game;
    }

}
