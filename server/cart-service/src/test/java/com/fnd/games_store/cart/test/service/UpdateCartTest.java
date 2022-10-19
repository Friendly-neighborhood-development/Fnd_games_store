package com.fnd.games_store.cart.test.service;

import com.fnd.games_store.cart.CartApplication;
import com.fnd.games_store.cart.repository.RedisRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class UpdateCartTest {



    @Mock
    RedisRepository repository;


    @BeforeEach
    void testSetup(){
//        when(repository.updateCart()).thenReturn();
    }




    @BeforeAll
    void afterTestCleanup(){

    }


}
