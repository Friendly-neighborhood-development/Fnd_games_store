package com.fnd.games_store.cart.dto;

import com.fnd.games_store.cart.entity.Game;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameResponseDTO {

    private String id;
    private String name;
    private String releaseDate;
    private String gameUrl;
    private BigDecimal price;
    private BigDecimal discount;
    private String description;
    private String base64Image;


    public GameResponseDTO(Game game) {
        this.id = game.getId();
        this.name = game.getName();
        this.releaseDate = game.getReleaseDate();
        this.price = game.getPrice();
        this.gameUrl = game.getGameUrl();
        this.discount = game.getDiscount();
        this.description = game.getDescription();
        this.base64Image = game.getBase64Image();
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name=" + name +
                ", releaseDate=" + releaseDate +
                ", gameUrl=" + gameUrl +
                ", price=" + price +
                ", discount=" + discount +
                ", description=" + description +
                ", base64Image=" + base64Image +
                "}";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameResponseDTO that = (GameResponseDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(releaseDate, that.releaseDate) && Objects.equals(gameUrl, that.gameUrl) && Objects.equals(price, that.price) && Objects.equals(discount, that.discount) && Objects.equals(description, that.description) && Objects.equals(base64Image, that.base64Image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, releaseDate, gameUrl, price, discount, description, base64Image);
    }
}
