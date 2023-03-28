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
        this.id = gameRequestDTO.getId();
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
        return Objects.equals(id, game.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
