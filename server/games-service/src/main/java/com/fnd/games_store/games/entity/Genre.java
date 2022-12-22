package com.fnd.games_store.games.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "genres")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Genre {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name ="uuid", strategy ="uuid2")
    @Column(name = "genre_id")
    private String id;

//    @ManyToMany
//    @JsonIgnore
//    private Game game;

    @Column(name = "genre_name")
    private String genre;


}
