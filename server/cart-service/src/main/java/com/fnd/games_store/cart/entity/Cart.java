package com.fnd.games_store.cart.entity;


import com.fnd.games_store.cart.dto.CartResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Data
@AllArgsConstructor
@ToString
@RedisHash("Cart")
public class Cart implements Serializable {

    @Id
    private String userId;

    private List<Game> gameData;


    public Cart() {

        this.userId = "";
        this.gameData = new ArrayList<>();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return Objects.equals(userId, cart.userId) && Objects.equals(gameData, cart.gameData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, gameData);
    }
}
