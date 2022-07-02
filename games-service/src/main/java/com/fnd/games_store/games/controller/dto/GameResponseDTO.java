package com.fnd.games_store.games.controller.dto;


import com.fnd.games_store.games.entity.Game;
import lombok.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class GameResponseDTO {
    private String id;
    private String name;
    private String genre;
    private String releaseDate;
    private String developer;
    private String publisher;
    private String platform;
    private String features;
    private BigDecimal price;
    private BigDecimal discount;
    private String description;

    public GameResponseDTO(){

    }

    public GameResponseDTO(String name, String genre, String releaseDate, String developer, String publisher, String platform, String features, BigDecimal price, BigDecimal discount, String description) {
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
    }

    public GameResponseDTO(Game game){
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
    }


}
