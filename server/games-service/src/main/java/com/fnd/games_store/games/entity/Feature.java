package com.fnd.games_store.games.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "features")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Feature {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name ="uuid", strategy ="uuid2")
    @Column(name = "feature_id")
    private String id;

    @ManyToMany(mappedBy = "feature")
    @JsonIgnore
    private List<Game> game;

    @Column(name = "feature_name")
    private String name;



}
