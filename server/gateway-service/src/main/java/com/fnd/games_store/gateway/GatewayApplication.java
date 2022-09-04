package com.fnd.games_store.gateway;

import com.fnd.games_store.gateway.dto.ValidationRequestDTO;
import com.fnd.games_store.gateway.dto.ValidationResponseDTO;
import com.fnd.games_store.gateway.feign.LoginServiceClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@Slf4j
@CrossOrigin
public class GatewayApplication implements CommandLineRunner {


    @Autowired
    LoginServiceClient loginClient;

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class,args);
    }

    @Override
    public void run(String... args) throws Exception {

        ValidationRequestDTO userValidationRequestDTO = new ValidationRequestDTO();
        userValidationRequestDTO.setToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTY2MjM3MjI0OCwiaWF0IjoxNjYyMjgyMjQ4fQ.gfw5FLa1cHRf5LoHwk-abWNxzDAfeSPrWYaTFTNu690");

        Boolean isUserValid = loginClient.validateUserByToken(userValidationRequestDTO).getIsUserValid();


        ValidationResponseDTO validationResponseDTO = new ValidationResponseDTO();

        validationResponseDTO.setIsUserValid(isUserValid);

        log.info(validationResponseDTO.getIsUserValid().toString());
    }
}
