package com.fnd.games_store.games.entity;


import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

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

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "game_genre",
               joinColumns = {@JoinColumn(name = "game_id")},
               inverseJoinColumns = {@JoinColumn(name ="genre_id")})
    private List<Genre> genre;

    private String releaseDate;
    @ManyToOne
    @JoinColumn(name = "developer_id")
    private Developer developer;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "game_platform",
            joinColumns = {@JoinColumn(name = "game_id")},
            inverseJoinColumns = {@JoinColumn(name ="platform_id")})
    private List<Platform> platform;
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "game_feature",
            joinColumns = {@JoinColumn(name = "game_id")},
            inverseJoinColumns = {@JoinColumn(name ="feature_id")})
    private List<Feature> feature;
    private BigDecimal price;
    private BigDecimal discount;
    private String description;
    private String base64Image;

    public Game(String name, List<Genre> genre, String releaseDate, Developer developer,Publisher publisher, List<Platform> platform,
                List<Feature> features, BigDecimal price, BigDecimal discount, String description, String base64Image) {
        this.name = name;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.developer = developer;
        this.publisher = publisher;
        this.platform = platform;
        this.feature = features;
        this.price = price;
        this.discount = discount;
        this.description = description;
        this.base64Image=base64Image;
    }


}
