package com.fnd.games_store.gateway.feign;


import com.fnd.games_store.gateway.dto.ValidationRequestDTO;
import com.fnd.games_store.gateway.dto.ValidationResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@FeignClient(name = "login-service")
public interface LoginServiceClient {

    @RequestMapping(value = "/validate",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ValidationResponseDTO> validateUserByToken(@RequestBody ValidationRequestDTO userValidationRequestDTO);

}
