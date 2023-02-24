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
public class OrderRequestDTO {


    private String userId;

    private List<GameRequestDTO> gameData;


    public OrderRequestDTO(Order order){
        this.userId = order.getUserId();
        this.gameData = order.getGames().stream().map(GameRequestDTO::new).collect(Collectors.toList());
    }


}
