package com.fnd.games_store.test.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fnd.games_store.login.LoginApplication;
import com.fnd.games_store.login.dto.AccountRequestDTO;
import com.fnd.games_store.login.dto.AccountResponseDTO;
import com.fnd.games_store.login.service.AccountRegistration;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = LoginApplication.class)
@AutoConfigureMockMvc
public class UserRegistrationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountRegistration service;


    private String username = "Alfonso";

    private String password = "original_password_123";

    private String email = "alfonso@email.com";

    private String id = "1";

    private ObjectMapper objectMapper = new ObjectMapper();

    private String jsonRequest;

    private AccountResponseDTO expectedResponse;

    private AccountRequestDTO properRequest;


    @Test
    void registerNewUser_ShouldReturnProperResponseEntity() throws Exception {

        MvcResult requestResult = mockMvc.perform(post("/v1/registration")
                        .content(jsonRequest).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk()).andReturn();

        String requestBody = requestResult.getResponse().getContentAsString();

        AccountResponseDTO actualResponse = objectMapper.readValue(requestBody, AccountResponseDTO.class);

        assertThat(actualResponse).isEqualTo(expectedResponse);

    }

    @BeforeEach
    void testSetup(){

        properRequest = createAppropriateRequestDTO(username, password, email);
        jsonRequest = objectToJsonMapper(properRequest);
        expectedResponse = createAppropriateResponseDTO(username, id);

        when(service.register(properRequest)).thenReturn(expectedResponse);

    }


    private AccountRequestDTO createAppropriateRequestDTO(String username, String password, String email){
        return new AccountRequestDTO(username, password,email);
    }

    private AccountResponseDTO createAppropriateResponseDTO(String username, String id){
        return new AccountResponseDTO(username, id);
    }

    private String objectToJsonMapper(AccountRequestDTO accountRequestDTO) {
        try{
            return objectMapper.writeValueAsString(accountRequestDTO);
        } catch(JsonProcessingException e){
            e.printStackTrace();
            return "";
        }
    }


}
