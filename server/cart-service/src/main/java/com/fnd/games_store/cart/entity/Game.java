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
    private String releaseDate;
    private String gameUrl;
    private BigDecimal price;
    private BigDecimal discount;
    private String description;
    private String base64Image;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(id, game.id) && Objects.equals(name, game.name) && Objects.equals(releaseDate, game.releaseDate) && Objects.equals(gameUrl, game.gameUrl) && Objects.equals(price, game.price) && Objects.equals(discount, game.discount) && Objects.equals(description, game.description) && Objects.equals(base64Image, game.base64Image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, releaseDate, gameUrl, price, discount, description, base64Image);
    }
}
