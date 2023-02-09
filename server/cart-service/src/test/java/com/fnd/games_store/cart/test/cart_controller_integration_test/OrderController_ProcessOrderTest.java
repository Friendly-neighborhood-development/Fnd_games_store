package com.fnd.games_store.cart.test.cart_controller_integration_test;


import com.fnd.games_store.cart.CartApplication;
import com.fnd.games_store.cart.rest.UserValidationClient;
import com.fnd.games_store.cart.service.OrderProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(classes = CartApplication.class)
public class OrderController_ProcessOrderTest {
    


    @MockBean
    protected OrderProcessingService service;


    @Autowired
    protected MockMvc mvc;

    @MockBean
    protected UserValidationClient userValidationClient;
    




    
    
}
