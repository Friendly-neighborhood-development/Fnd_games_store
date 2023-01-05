package com.fnd.games_store.games.dto.genre;

import com.fnd.games_store.games.entity.Publisher;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class GenreResponseDTO {


    private String id;

    private String name;


    public GenreResponseDTO(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public GenreResponseDTO(GenreResponseDTO genre) {
        this.id = genre.getId();
        this.name = genre.getName();
    }
}
