package com.fnd.games_store.orders.controller;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.fnd.games_store.orders.dto.GameResponseDTO;
import com.fnd.games_store.orders.dto.OrderResponseDTO;
import com.fnd.games_store.orders.service.OrderFetcher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest(classes = OrderController.class)
@AutoConfigureMockMvc
public class GetOrderDataTest {



    @MockBean
    protected OrderFetcher service;

    @Autowired
    protected MockMvc mvc;

    @Autowired
    protected ObjectMapper objectMapper;

    protected String userId = "user1";


    protected OrderResponseDTO mockedOrderResponse = new OrderResponseDTO();;

    protected List<GameResponseDTO> testGameList = new ArrayList<>();

    private OffsetDateTime testCaseInitTime = OffsetDateTime.now();

    protected OrderResponseDTO expectedOrderData = new OrderResponseDTO();



    @Test
    void getDataEndpoint_ShouldReturnProperResponse() throws Exception {


        MvcResult mvcResult = mvc.perform(post("/v1/purchases/"+userId)
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk()).andReturn();

        String requestBody = mvcResult.getResponse().getContentAsString();

        OrderResponseDTO actualOrderData = objectMapper.readValue(requestBody, OrderResponseDTO.class);

        assertThat(actualOrderData).isEqualTo(expectedOrderData);

    }





    @BeforeEach
    void testSetup(){

        testGameList.add(createTestGameEntity("1"));
        mockedOrderResponse.setGameData(testGameList);

        expectedOrderData.setGameData(testGameList);

        when(service.fetchOrderData(userId)).thenReturn(mockedOrderResponse);

    }


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
