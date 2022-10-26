package com.fnd.games_store.cart.test.controller_integration_test;


import com.fnd.games_store.cart.CartApplication;
import com.fnd.games_store.cart.controller.CartCrudController;
import com.fnd.games_store.cart.dto.CartRequestDTO;
import com.fnd.games_store.cart.service.CartCrudService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;



import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@SpringBootTest(classes = CartApplication.class)
@AutoConfigureMockMvc
public class GetCartContentTest {



    @Autowired
    private MockMvc mvc;

    @MockBean
    private CartCrudService service;


    @Test
    void test_getCartContent() throws Exception {

        MvcResult result = this.mvc.perform(post("/v1/update")
                                    .content("")
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .accept(MediaType.APPLICATION_JSON))
                                    .andExpect(status().isOk())
                                    .andReturn();

    }



    @BeforeEach
    void testSetup(){


    }



}
