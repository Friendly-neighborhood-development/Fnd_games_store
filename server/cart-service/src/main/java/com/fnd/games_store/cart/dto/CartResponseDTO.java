package com.fnd.games_store.cart.dto;

import com.fnd.games_store.cart.entity.Cart;
import com.fnd.games_store.cart.entity.Game;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartResponseDTO {


    private String userId;

    private Set<Game> gameData;

    public CartResponseDTO(Cart cart){
        this.userId = cart.getUserId();
        this.gameData = cart.getGameData();
    }

    public CartResponseDTO(CartRequestDTO cartRequestDTO){
        this.userId = cartRequestDTO.getUserId();
        this.gameData = cartRequestDTO.getGameData();
    }


}
