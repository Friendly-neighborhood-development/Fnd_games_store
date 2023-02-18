package com.fnd.games_store.orders.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderRequestDTO {


    private String userId;

    private List<GameRequestDTO> gameData;


}
