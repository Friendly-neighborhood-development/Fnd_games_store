package com.fnd.games_store.cart.test.controller_integration_test;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fnd.games_store.cart.CartApplication;
import com.fnd.games_store.cart.dto.CartResponseDTO;
import com.fnd.games_store.cart.test.utilities.ControllerTestUtilities;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@SpringBootTest(classes = CartApplication.class)
@AutoConfigureMockMvc
@Slf4j
public class UpdateCartTest extends ControllerTestUtilities {

    @Test
    void test_updateCartContent() throws Exception {

        MvcResult result = this.mvc.perform(post("/v1/update")
                                    .content(jsonCartRequestDTO(createAppropriateCartRequest(userId,testGameSet)))
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .accept(MediaType.APPLICATION_JSON))
                                    .andExpect(status().isOk())
                                    .andReturn();

        String body = result.getResponse().getContentAsString();
        CartResponseDTO response = new ObjectMapper().readValue(body, CartResponseDTO.class);

        assertThat(response).isEqualTo(createAppropriateCartResponse(userId,testGameSet));

        verify(service).updateCart(createAppropriateCartRequest(userId,testGameSet));
    }



    @BeforeEach
    void testSetup(){
        testGameSet.add(createTestGameEntity(1));

        when(service.updateCart(createAppropriateCartRequest(userId,testGameSet))).thenReturn(createAppropriateCartResponse(userId, testGameSet));

    }



}



