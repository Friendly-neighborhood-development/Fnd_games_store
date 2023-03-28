package com.fnd.games_store.orders.controller;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fnd.games_store.orders.OrdersApplication;
import com.fnd.games_store.orders.dto.OrderResponseDTO;
import com.fnd.games_store.orders.dto.ValidationResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

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
                        .header("authorization", "")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk()).andReturn();

        String requestBody = mvcResult.getResponse().getContentAsString();

        List<OrderResponseDTO> actualOrderData = objectMapper.readValue(requestBody, new TypeReference<List<OrderResponseDTO>>() {});

        log.info("actual order data: "+actualOrderData.toString());
        log.info("expected order data: "+expectedOrderData.getGameData().toString());

        assertThat(actualOrderData.get(0)).isEqualTo(expectedOrderData);

    }

    @BeforeEach
    void testSetup(){

        testGameList.add(createTestGameEntity("1"));



        mockedOrderResponse.add(expectedOrderData);

        expectedOrderData.setGameData(testGameList);

        when(service.fetchOrderData(userId)).thenReturn(mockedOrderResponse);

    }

    @BeforeEach
    void userValidationFeignClientSetup(){

        Boolean tokenIsValid = true;

        ValidationResponseDTO response = new ValidationResponseDTO();
        response.setIsTokenValid(true);

        ResponseEntity<ValidationResponseDTO> responseBody = ResponseEntity.ok(response);

        when(userValidationClient.validateUser("")).thenReturn(responseBody);
    }

}
