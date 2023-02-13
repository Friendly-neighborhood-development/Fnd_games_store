package com.fnd.games_store.orders.entity;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
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
    private String id;
    @ManyToOne
    private Order order;
    private String name;
    private String releaseDate;
    private BigDecimal price;
    private BigDecimal discount;
    private String description;
    private String base64Image;


    public Game(Order order, String name, String releaseDate, BigDecimal price, BigDecimal discount, String description, String base64Image) {
        this.order = order;
        this.name = name;
        this.releaseDate = releaseDate;
        this.price = price;
        this.discount = discount;
        this.description = description;
        this.base64Image = base64Image;
    }
}
