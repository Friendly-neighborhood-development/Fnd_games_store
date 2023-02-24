package com.fnd.games_store.orders.controller;


import com.fnd.games_store.orders.OrdersApplication;
import com.fnd.games_store.orders.dto.OrderResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest(classes = OrdersApplication.class)
@AutoConfigureMockMvc
@Slf4j
public class GetOrderDataTest extends ControllerTestUtils{


    @Test
    void getDataEndpoint_ShouldReturnProperResponse() throws Exception {


        MvcResult mvcResult = mvc.perform(get("/v1/purchases/"+userId)
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk()).andReturn();

        String requestBody = mvcResult.getResponse().getContentAsString();

        OrderResponseDTO actualOrderData = objectMapper.readValue(requestBody, OrderResponseDTO.class);

        log.info("actual order data: "+actualOrderData.toString());
        log.info("expected order data: "+expectedOrderData.toString());

        assertThat(actualOrderData).isEqualTo(expectedOrderData);

    }

    @BeforeEach
    void testSetup(){

        testGameList.add(createTestGameEntity("1"));
        mockedOrderResponse.setGameData(testGameList);

        expectedOrderData.setGameData(testGameList);

        when(service.fetchOrderData(userId)).thenReturn(mockedOrderResponse);

    }

}
