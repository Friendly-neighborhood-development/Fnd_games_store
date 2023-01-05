package com.fnd.games_store.games.dto.game;


import com.fnd.games_store.games.dto.developer.DeveloperResponseDTO;
import com.fnd.games_store.games.dto.feature.FeatureResponseDTO;
import com.fnd.games_store.games.dto.genre.GenreResponseDTO;
import com.fnd.games_store.games.dto.platform.PlatformResponseDTO;
import com.fnd.games_store.games.dto.publisher.PublisherResponseDTO;
import com.fnd.games_store.games.entity.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class GameResponseDTO {
    private String id;
    private String name;
    private List<GenreResponseDTO> genre;
    private String releaseDate;
    private DeveloperResponseDTO developer;
    private PublisherResponseDTO publisher;
    private List<PlatformResponseDTO> platform;
    private List<FeatureResponseDTO> features;
    private BigDecimal price;
    private BigDecimal discount;
    private String description;
    private String base64Image;

    public GameResponseDTO(){

    }

    public GameResponseDTO(String name, List<GenreResponseDTO> genre, String releaseDate, DeveloperResponseDTO developer,
                          PublisherResponseDTO publisher, List<PlatformResponseDTO> platform, List<FeatureResponseDTO> features, BigDecimal price,
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
        this.genre = game.getGenre().stream().map(GenreResponseDTO::new).collect(Collectors.toList());
        this.releaseDate = game.getReleaseDate();
        this.developer = new DeveloperResponseDTO(game.getDeveloper());
        this.publisher = new PublisherResponseDTO(game.getPublisher());
        this.platform = game.getPlatform().stream().map(PlatformResponseDTO::new).collect(Collectors.toList());
        this.features = game.getFeature().stream().map(FeatureResponseDTO::new).collect(Collectors.toList());
        this.price = game.getPrice();
        this.discount = game.getDiscount();
        this.description = game.getDescription();
        this.base64Image=game.getBase64Image();
    }


}
