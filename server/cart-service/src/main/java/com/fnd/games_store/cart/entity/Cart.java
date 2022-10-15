package com.fnd.games_store.cart.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart implements Serializable {


    private String userId;

    private String gameId;

    private Set<Game> gameObjects;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return Objects.equals(userId, cart.userId) && Objects.equals(gameId, cart.gameId) && Objects.equals(gameObjects, cart.gameObjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, gameId, gameObjects);
    }
}
