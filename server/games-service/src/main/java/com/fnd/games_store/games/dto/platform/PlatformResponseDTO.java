package com.fnd.games_store.games.dto.platform;

import com.fnd.games_store.games.entity.Genre;
import com.fnd.games_store.games.entity.Platform;

public class PlatformResponseDTO {
    private String id;

    private String name;


    public PlatformResponseDTO(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public PlatformResponseDTO(Platform platform) {
        this.id = platform.getId();
        this.name = platform.getName();
    }
}
