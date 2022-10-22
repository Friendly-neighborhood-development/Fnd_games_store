package com.fnd.games_store.cart.test.utilities;

import com.fnd.games_store.cart.dto.CartRequestDTO;
import com.fnd.games_store.cart.dto.CartResponseDTO;
import com.fnd.games_store.cart.dto.GameResponseDTO;

import java.util.ArrayList;
import java.util.List;

public class ServiceTestUtilities {


    protected String userId = "user_1";

    protected String gameId = "game_1";

    protected List<GameResponseDTO> testGameList = new ArrayList<>();

    protected CartRequestDTO testRequestCart = new CartRequestDTO();

    protected CartResponseDTO testResponseCart = new CartResponseDTO();


    protected ServiceTestUtilities() {

    }



}
