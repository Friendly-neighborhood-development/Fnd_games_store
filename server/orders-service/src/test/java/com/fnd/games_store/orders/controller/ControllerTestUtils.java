package com.fnd.games_store.orders.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fnd.games_store.orders.dto.GameResponseDTO;
import com.fnd.games_store.orders.dto.OrderResponseDTO;
import com.fnd.games_store.orders.rest.UserValidationClient;
import com.fnd.games_store.orders.service.OrderFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class ControllerTestUtils {

    @MockBean
    protected UserValidationClient userValidationClient;
    @MockBean
    protected OrderFetcher service;

    @Autowired
    protected MockMvc mvc;

    @Autowired
    protected ObjectMapper objectMapper;

    protected String userId = "user1";


    protected List<OrderResponseDTO> mockedOrderResponse = new ArrayList<>();

    protected List<GameResponseDTO> testGameList = new ArrayList<>();

    private OffsetDateTime testCaseInitTime = OffsetDateTime.now();

    protected OrderResponseDTO expectedOrderData = new OrderResponseDTO();


    protected GameResponseDTO createTestGameEntity(String differenceParameter){

        GameResponseDTO testGameEntity = new GameResponseDTO();
        testGameEntity.setId(differenceParameter);
        testGameEntity.setName("Doom Eternal" + differenceParameter);
        testGameEntity.setReleaseDate("2009"+differenceParameter);
        testGameEntity.setPrice(BigDecimal.valueOf(1000));
        testGameEntity.setDiscount(BigDecimal.valueOf(20));
        testGameEntity.setDescription(""+differenceParameter);
        testGameEntity.setBase64Image(""+differenceParameter);

        return testGameEntity;
    }


}
