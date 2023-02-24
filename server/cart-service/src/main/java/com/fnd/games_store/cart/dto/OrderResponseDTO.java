package com.fnd.games_store.cart.dto;

import com.fnd.games_store.cart.entity.Game;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDTO {

    private List<Game> gameData;


}
