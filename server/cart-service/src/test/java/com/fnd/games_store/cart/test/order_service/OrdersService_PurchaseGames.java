package com.fnd.games_store.cart.test.order_service;


import com.fnd.games_store.cart.repository.CartRepository;
import com.fnd.games_store.cart.service.OrderProcessingService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class OrdersService_PurchaseGames {



    @Mock
    protected CartRepository repository;


    @InjectMocks
    protected OrderProcessingService service;









}
