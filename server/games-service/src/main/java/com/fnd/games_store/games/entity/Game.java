package com.fnd.games_store.games.entity;


import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
 * @author SergeyPodgorny
 */


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
    private String name;
//    @OneToMany(mappedBy = "genres")
//    @JoinTable(name = "games_catalogue_genres")

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "games_genres",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name ="authority_id"))
    private List<String> genre;

//    private String genre;
    private String releaseDate;
    private String developer;
    private String publisher;
    private String platform;
    private String features;
    private BigDecimal price;
    private BigDecimal discount;
    private String description;
    private String base64Image;

    public Game(String name, List<String> genre, String releaseDate, String developer, String publisher, String platform,
                String features, BigDecimal price, BigDecimal discount, String description, String base64Image) {
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
        this.base64Image=base64Image;
    }

//    public Game(String name, String genre, String releaseDate, String developer, String publisher, String platform,
//                String features, BigDecimal price, BigDecimal discount, String description, String base64Image) {
//        this.name = name;
//        this.genre = genre;
//        this.releaseDate = releaseDate;
//        this.developer = developer;
//        this.publisher = publisher;
//        this.platform = platform;
//        this.features = features;
//        this.price = price;
//        this.discount = discount;
//        this.description = description;
//        this.base64Image=base64Image;
//    }

}
