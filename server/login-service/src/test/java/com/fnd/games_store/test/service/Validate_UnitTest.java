package com.fnd.games_store.test.service;


import com.fnd.games_store.login.jwt_utils.JwtValidator;
import com.fnd.games_store.login.service.implementation.ValidationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;


import static org.assertj.core.api.Assertions.*;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;



@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class Validate_UnitTest {


    @Mock
    private JwtValidator jwtValidator;

    @InjectMocks
    private ValidationServiceImpl validationService;

    private String incomingToken = "============================token";

    @Test
    void validate_ShouldReturnTrueForCorrectToken(){
        assertThat(validationService.validate(incomingToken)).isTrue();
    }



    @BeforeEach
    void testSetup(){

        when(jwtValidator.validateJwtToken(incomingToken)).thenReturn(true);

    }

}
