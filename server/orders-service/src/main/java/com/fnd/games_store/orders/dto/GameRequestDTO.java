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
public class GameRequestDTO {


    private String id;
    private String name;
    private String releaseDate;
    private BigDecimal price;
    private BigDecimal discount;
    private String description;
    private String base64Image;


    public GameRequestDTO(Game game) {
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
        GameRequestDTO gameDTO = (GameRequestDTO) o;
        return Objects.equals(name, gameDTO.name) && Objects.equals(releaseDate, gameDTO.releaseDate) && Objects.equals(price, gameDTO.price) && Objects.equals(discount, gameDTO.discount) && Objects.equals(description, gameDTO.description) && Objects.equals(base64Image, gameDTO.base64Image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, releaseDate, price, discount, description, base64Image);
    }
}
