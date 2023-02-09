package com.fnd.games_store.cart.dto;

import com.fnd.games_store.cart.entity.Cart;
import com.fnd.games_store.cart.entity.Game;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MessageToOrderServiceDTO {


    private String userId;

    private List<Game> gameData;

    public MessageToOrderServiceDTO(Cart cart){
        this.userId = cart.getUserId();
        this.gameData = cart.getGameData();
    }

}
