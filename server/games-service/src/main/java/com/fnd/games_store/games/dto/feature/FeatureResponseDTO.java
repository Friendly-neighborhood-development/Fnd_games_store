package com.fnd.games_store.games.dto.feature;

import com.fnd.games_store.games.entity.Feature;
import com.fnd.games_store.games.entity.Platform;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class FeatureResponseDTO {

    private String id;

    private String name;


    public FeatureResponseDTO(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public FeatureResponseDTO(Feature feature) {
        this.id = feature.getId();
        this.name = feature.getName();
    }
}
