package com.fnd.games_store.test.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fnd.games_store.login.LoginApplication;
import com.fnd.games_store.login.dto.ValidationResponseDTO;
import com.fnd.games_store.login.service.ValidationService;
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


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(classes = LoginApplication.class)
@AutoConfigureMockMvc
@Slf4j
public class ValidationControllerTest {


    @Autowired
    private MockMvc mvc;

    private String referenceHeaderName = "authorization";

    private String referenceHeaderValue = "Bearer  ";

    private ObjectMapper objectMapper = new ObjectMapper();

    @MockBean
    private ValidationService validationService;


    @Test
    void validateUser_ShouldDetermineIfHeaderIsPresent() throws Exception {


        MvcResult requestResult = this.mvc.perform(post("/v1/validate")
                .header(referenceHeaderName,referenceHeaderValue)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String requestBody = requestResult.getResponse().getContentAsString();

        ValidationResponseDTO response = objectMapper.readValue(requestBody,  ValidationResponseDTO.class);

        assertThat(response).isEqualTo(createSuccessfulTokenValidationResponse());


    }


    @BeforeEach
    void testSetup(){
        when(validationService.validate(referenceHeaderValue)).thenReturn(true);
    }

    private ValidationResponseDTO createSuccessfulTokenValidationResponse(){
        return new ValidationResponseDTO(true);
    }


}
