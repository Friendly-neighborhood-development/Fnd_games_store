package com.fnd.games_store.orders.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fnd.games_store.orders.dto.GameRequestDTO;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "games")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Game {
    @NotNull
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name ="uuid", strategy ="uuid2")
    @Column(name = "game_id")
    @ToString.Exclude
    private String id;
    @ManyToMany(mappedBy = "games")
    @JsonIgnore
    @ToString.Exclude
    private List<Order> order;
    private String name;
    private String releaseDate;
    private BigDecimal price;
    private BigDecimal discount;
    private String description;
    private String base64Image;

    public Game(GameRequestDTO gameRequestDTO){
        this.name = gameRequestDTO.getName();
        this.releaseDate = gameRequestDTO.getReleaseDate();
        this.price = gameRequestDTO.getPrice();
        this.discount = gameRequestDTO.getDiscount();
        this.description = gameRequestDTO.getDescription();
        this.base64Image = gameRequestDTO.getBase64Image();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(order, game.order) && Objects.equals(name, game.name) && Objects.equals(releaseDate, game.releaseDate) && Objects.equals(price, game.price) && Objects.equals(discount, game.discount) && Objects.equals(description, game.description) && Objects.equals(base64Image, game.base64Image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, name, releaseDate, price, discount, description, base64Image);
    }
}
