package com.fnd.games_store.cart.entity;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Game implements Serializable {

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
    private String base64Image;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(id, game.id) && Objects.equals(name, game.name) && Objects.equals(genre, game.genre) && Objects.equals(releaseDate, game.releaseDate) && Objects.equals(developer, game.developer) && Objects.equals(publisher, game.publisher) && Objects.equals(platform, game.platform) && Objects.equals(features, game.features) && Objects.equals(price, game.price) && Objects.equals(discount, game.discount) && Objects.equals(description, game.description) && Objects.equals(base64Image, game.base64Image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, genre, releaseDate, developer, publisher, platform, features, price, discount, description, base64Image);
    }
}
