package com.fnd.games_store.cart.test.cart_controller_integration_test;

import com.fnd.games_store.cart.CartApplication;
import com.fnd.games_store.cart.dto.GameResponseDTO;
import com.fnd.games_store.cart.dto.ValidationResponseDTO;
import com.fnd.games_store.cart.test.utilities.CartControllerTestUtilities;
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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest(classes = CartApplication.class)
@AutoConfigureMockMvc
@Slf4j
public class CartController_GetCartContentTest extends CartControllerTestUtilities {



    @Test
    void getCartContent_ShouldReturnProperData() throws Exception {

        MvcResult result = this.mvc.perform(post("/v1/content")
                                .header("authorization", "")
                                .content(jsonGameRequestDTO(createAppropriateGameRequestDTO(userId)))
                                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                                .andExpect(status().isOk())
                                .andReturn();

        String body = result.getResponse().getContentAsString();

        List<GameResponseDTO> response = objectMapper.readValue(body, ArrayList.class);

        assertThat(testGameResponse.toString()).isEqualTo(response.toString());


    }

    @Test
    void getCartContent_ShouldReturnInstanceOfList() throws Exception {

        MvcResult result = this.mvc.perform(post("/v1/content")
                        .header("authorization", "")
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

    @BeforeEach
    void userValidationFeignClientSetup(){

        Boolean tokenIsValid = true;

        ValidationResponseDTO response = new ValidationResponseDTO();
        response.setIsTokenValid(true);

        ResponseEntity<ValidationResponseDTO> responseBody = ResponseEntity.ok(response);

        when(userValidationClient.validateUser("")).thenReturn(responseBody);
    }

}
