package com.fnd.games_store.games.dto.game;


import com.fnd.games_store.games.dto.developer.DeveloperResponseDTO;
import com.fnd.games_store.games.dto.publisher.PublisherResponseDTO;
import com.fnd.games_store.games.entity.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class GameResponseDTO {
    private String id;
    private String name;
    private List<Genre> genre;
    private String releaseDate;
    private DeveloperResponseDTO developer;
    private PublisherResponseDTO publisher;
    private List<Platform> platform;
    private List<Feature> features;
    private BigDecimal price;
    private BigDecimal discount;
    private String description;
    private String base64Image;

    public GameResponseDTO(){

    }

    public GameResponseDTO(String name, List<Genre> genre, String releaseDate, DeveloperResponseDTO developer,
                          PublisherResponseDTO publisher, List<Platform> platform, List<Feature> features, BigDecimal price,
                          BigDecimal discount, String description, String base64Image) {
        this.name = name;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.developer = developer;
        this.publisher = publisher;
        this.platform = platform;
        this.features = features;
        this.price = price;
        this.discount = discount;
        this.description = description;
        this.base64Image = base64Image;
    }

    public GameResponseDTO(Game game){
        this.id = game.getId();
        this.name = game.getName();
        this.genre = game.getGenre();
        this.releaseDate = game.getReleaseDate();
        this.developer = new DeveloperResponseDTO(game.getDeveloper());
        this.publisher = new PublisherResponseDTO(game.getPublisher());
        this.platform = game.getPlatform();
        this.features = game.getFeature();
        this.price = game.getPrice();
        this.discount = game.getDiscount();
        this.description = game.getDescription();
        this.base64Image=game.getBase64Image();
    }


}
