package com.fnd.games_store.orders.dto;


import com.fnd.games_store.orders.entity.Game;
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


}
