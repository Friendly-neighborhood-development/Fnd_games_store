package com.fnd.games_store.cart.test.cart_controller_integration_test;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fnd.games_store.cart.CartApplication;
import com.fnd.games_store.cart.dto.CartResponseDTO;
import com.fnd.games_store.cart.dto.ValidationResponseDTO;
import com.fnd.games_store.cart.service.OrderProcessingService;
import com.fnd.games_store.cart.test.utilities.ControllerTestUtilities;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = CartApplication.class)
@AutoConfigureMockMvc
public class OrderController_ProcessOrderTest extends ControllerTestUtilities {
    


    @MockBean
    protected OrderProcessingService service;


    @Test
    void OrderController_ShouldReturnProperCartData() throws Exception {


        MvcResult result = this.mvc.perform(post("/v1/purchase" + "/"+ userId)
                        .header("authorization", "")
                        .content(jsonCartRequestDTO(createAppropriateCartRequest(userId,testGameSet)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String body = result.getResponse().getContentAsString();
        CartResponseDTO response = new ObjectMapper().readValue(body, CartResponseDTO.class);

        assertThat(response).isEqualTo(createAppropriateCartResponse(userId,testGameSet));

    }


    @BeforeEach
    void testSetup(){
        testGameSet.add(createTestGameEntity(1));

        when(service.purchaseGames(userId)).thenReturn(createAppropriateCartResponse(userId, testGameSet));
    }



    @BeforeEach
    void feignClientSetup(){

        Boolean tokenIsValid = true;

        ValidationResponseDTO response = new ValidationResponseDTO();
        response.setIsTokenValid(true);

        ResponseEntity<ValidationResponseDTO> responseBody = ResponseEntity.ok(response);

        when(userValidationClient.validateUser("")).thenReturn(responseBody);

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
