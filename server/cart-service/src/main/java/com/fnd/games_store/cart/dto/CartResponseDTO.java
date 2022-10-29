package com.fnd.games_store.cart.dto;

import com.fnd.games_store.cart.entity.Cart;
import com.fnd.games_store.cart.entity.Game;
import lombok.*;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
