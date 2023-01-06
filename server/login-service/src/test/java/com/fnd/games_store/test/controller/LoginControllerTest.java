package com.fnd.games_store.test.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fnd.games_store.login.LoginApplication;
import com.fnd.games_store.login.dto.LoginRequestDTO;
import com.fnd.games_store.login.dto.LoginResponseDTO;
import com.fnd.games_store.login.service.implementation.LoginServiceImpl;
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
public class LoginControllerTest {


    @Autowired
    private MockMvc mvc;


    @MockBean
    LoginServiceImpl loginService;

    private String username;

    private String password;

    protected ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void login_ShouldReturnProperResponseObject() throws Exception {
            MvcResult requestResult = this.mvc.perform(post("/v1/authorization")
                            .content(jsonCartRequestDTO(createAppropriateGameRequestDTO(username,password)))
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON)).
                            andExpect(status().isOk()).andReturn();

            String body = requestResult.getResponse().getContentAsString();
            LoginResponseDTO loginResponseDTO = new ObjectMapper().readValue(body,LoginResponseDTO.class);
            assertThat(loginResponseDTO).isEqualTo(new LoginResponseDTO("","token"));

    }





    @BeforeEach
    void setUp(){
        username = "admin";
        password = "123";
        //TODO refactor test later
        when(loginService.login(username, password)).thenReturn(new LoginResponseDTO("","token"));
    }


    private LoginRequestDTO createAppropriateGameRequestDTO(String username, String password){
        return new LoginRequestDTO(username,password);
    }

    private String jsonCartRequestDTO(LoginRequestDTO loginRequestDTO) {

        try {
            return objectMapper.writeValueAsString(createAppropriateGameRequestDTO(loginRequestDTO.getUsername(),loginRequestDTO.getPassword()));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }


}
