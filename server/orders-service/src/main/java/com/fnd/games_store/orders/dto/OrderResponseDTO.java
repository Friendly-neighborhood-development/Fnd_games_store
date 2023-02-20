package com.fnd.games_store.orders.dto;

import com.fnd.games_store.orders.entity.Order;

import java.util.List;
import java.util.stream.Collectors;

public class OrderResponseDTO {


    private List<GameResponseDTO> gameData;


    public OrderResponseDTO(Order order){
        this.gameData = order.getGames().stream().map(GameResponseDTO::new).collect(Collectors.toList());
    }


}
