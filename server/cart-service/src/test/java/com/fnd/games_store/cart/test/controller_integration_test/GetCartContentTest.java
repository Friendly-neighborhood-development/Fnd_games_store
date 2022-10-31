package com.fnd.games_store.cart.test.controller_integration_test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fnd.games_store.cart.CartApplication;
import com.fnd.games_store.cart.dto.GameRequestDTO;
import com.fnd.games_store.cart.dto.GameResponseDTO;
import com.fnd.games_store.cart.service.CartCrudService;
import com.fnd.games_store.cart.test.utilities.ControllerTestUtilities;
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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest(classes = CartApplication.class)
@AutoConfigureMockMvc
@Slf4j
public class GetCartContentTest extends ControllerTestUtilities {


    @Test
    void getCartContent_ShouldReturnProperData() throws Exception {

        MvcResult result = this.mvc.perform(post("/v1/getContent")
                                .content(jsonGameRequestDTO(createAppropriateGameRequestDTO(userId)))
                                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                                .andExpect(status().isOk())
                                .andReturn();

        String body = result.getResponse().getContentAsString();

        List<GameResponseDTO> response = objectMapper.readValue(body, ArrayList.class);

        assertThat(response.toString()).isEqualTo(testGameResponse.toString());

    }

    @Test
    void getCartContent_ShouldReturnInstanceOfList() throws Exception {

        MvcResult result = this.mvc.perform(post("/v1/getContent")
                        .content(jsonGameRequestDTO(createAppropriateGameRequestDTO(userId)))
                        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String body = result.getResponse().getContentAsString();

        List<GameResponseDTO> response = objectMapper.readValue(body, ArrayList.class);

        assertThat(response).isExactlyInstanceOf(testGameResponse.getClass());
    }





    @BeforeEach
    void testSetup(){

        testGameResponse.add(createTestGameResponse(1));
//        testGameResponse.add(createTestGameResponse(2));
//        testGameResponse.add(createTestGameResponse(3));

        when(service.getCartContent(userId)).thenReturn(testGameResponse);

    }

}
