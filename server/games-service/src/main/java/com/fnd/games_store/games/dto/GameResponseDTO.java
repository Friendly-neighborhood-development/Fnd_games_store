package com.fnd.games_store.games.dto;


import com.fnd.games_store.games.entity.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
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
    private Developer developer;
    private Publisher publisher;
    private List<Platform> platform;
    private String features;
    private BigDecimal price;
    private BigDecimal discount;
    private String description;
    private String base64Image;

    public GameResponseDTO(){

    }

    public GameResponseDTO(String name, List<Genre> genre, String releaseDate, Developer developer,
                          Publisher publisher, List<Platform> platform, String features, BigDecimal price,
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
        this.developer = game.getDeveloper();
        this.publisher = game.getPublisher();
        this.platform = game.getPlatform();
        this.features = game.getFeatures();
        this.price = game.getPrice();
        this.discount = game.getDiscount();
        this.description = game.getDescription();
        this.base64Image=game.getBase64Image();
    }


}
