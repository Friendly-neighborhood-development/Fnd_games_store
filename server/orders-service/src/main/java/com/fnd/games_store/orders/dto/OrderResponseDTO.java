package com.fnd.games_store.orders.dto;

import com.fnd.games_store.orders.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderResponseDTO {


    private List<GameResponseDTO> gameData;


    public OrderResponseDTO(Order order){
        this.gameData = order.getGames().stream().map(GameResponseDTO::new).collect(Collectors.toList());
    }


}
