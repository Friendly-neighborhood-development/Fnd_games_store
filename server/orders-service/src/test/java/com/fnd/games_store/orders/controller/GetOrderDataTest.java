package com.fnd.games_store.orders.controller;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.fnd.games_store.orders.dto.GameResponseDTO;
import com.fnd.games_store.orders.dto.OrderResponseDTO;
import com.fnd.games_store.orders.service.OrderFetcher;
import lombok.extern.slf4j.Slf4j;
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
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class GetOrderDataTest extends ControllerTestUtils{







    @Test
    void getDataEndpoint_ShouldReturnProperResponse() throws Exception {


        MvcResult mvcResult = mvc.perform(post("/v1/purchases/"+userId)
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
