package com.fnd.games_store.cart.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart implements Serializable {


    private String sessionId;

    private String userId;

    private List<String> shoppingList;

}
