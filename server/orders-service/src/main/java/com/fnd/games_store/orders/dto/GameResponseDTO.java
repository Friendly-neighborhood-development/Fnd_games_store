package com.fnd.games_store.orders.dto;


import com.fnd.games_store.orders.entity.Game;
import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GameResponseDTO {


    private String id;
    private String name;
    private String releaseDate;
    private BigDecimal price;
    private BigDecimal discount;
    private String description;
    private String base64Image;



    public GameResponseDTO(Game game) {
        this.id = game.getId();
        this.name = game.getName();
        this.releaseDate = game.getReleaseDate();
        this.price = game.getPrice();
        this.discount = game.getDiscount();
        this.description = game.getDescription();
        this.base64Image = game.getBase64Image();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameResponseDTO that = (GameResponseDTO) o;
        return Objects.equals(name, that.name) && Objects.equals(releaseDate, that.releaseDate) && Objects.equals(price, that.price) && Objects.equals(discount, that.discount) && Objects.equals(description, that.description) && Objects.equals(base64Image, that.base64Image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, releaseDate, price, discount, description, base64Image);
    }
}
