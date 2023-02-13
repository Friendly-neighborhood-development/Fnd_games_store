package com.fnd.games_store.orders.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GameDTO {


    private String id;
    private String name;
    private String releaseDate;
    private BigDecimal price;
    private BigDecimal discount;
    private String description;
    private String base64Image;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameDTO gameDTO = (GameDTO) o;
        return Objects.equals(id, gameDTO.id) && Objects.equals(name, gameDTO.name) && Objects.equals(releaseDate, gameDTO.releaseDate) && Objects.equals(price, gameDTO.price) && Objects.equals(discount, gameDTO.discount) && Objects.equals(description, gameDTO.description) && Objects.equals(base64Image, gameDTO.base64Image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, releaseDate, price, discount, description, base64Image);
    }
}
