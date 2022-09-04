package com.fnd.games_store.gateway.feign;

import com.fnd.games_store.gateway.dto.UserValidationRequestDTO;
import com.fnd.games_store.gateway.dto.UserValidationResponseDTO;
import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "login-service")
public interface LoginServiceClient {

    @GetMapping("/validate")
    public ResponseEntity<UserValidationResponseDTO> validateUserByToken(@RequestBody UserValidationRequestDTO userValidationRequestDTO);

}
