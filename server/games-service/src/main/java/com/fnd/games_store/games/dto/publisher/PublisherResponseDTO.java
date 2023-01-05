package com.fnd.games_store.games.dto.publisher;


import com.fnd.games_store.games.entity.Publisher;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class PublisherResponseDTO {
    private String id;

    private String name;


    public PublisherResponseDTO(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public PublisherResponseDTO(Publisher publisher) {
        this.id = publisher.getId();
        this.name = publisher.getName();
    }
}
