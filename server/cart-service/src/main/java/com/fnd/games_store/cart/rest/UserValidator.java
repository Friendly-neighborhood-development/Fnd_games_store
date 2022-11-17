package com.fnd.games_store.cart.rest;

import com.fnd.games_store.cart.dto.ValidationResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient("login-service")
public interface UserValidator {


    @RequestMapping(method = RequestMethod.POST, value = "/v1/validate", consumes = "application/json")
    ResponseEntity<ValidationResponseDTO> validateUser(String token);

}
