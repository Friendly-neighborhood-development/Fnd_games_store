package com.fnd.games_store.gateway.feign;


import com.fnd.games_store.gateway.dto.UserValidationResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "login-service")
public interface LoginServiceClient {

    @RequestMapping(value = "/validate", method = RequestMethod.GET)
    public ResponseEntity<UserValidationResponseDTO> validateUserByToken();

}
