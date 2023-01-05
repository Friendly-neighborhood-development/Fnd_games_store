package com.fnd.games_store.games.dto.developer;

import com.fnd.games_store.games.entity.Developer;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class DeveloperResponseDTO {


    private String id;

    private String name;


    public DeveloperResponseDTO(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public DeveloperResponseDTO(Developer developer) {
        this.id = developer.getId();
        this.name = developer.getName();
    }
}
