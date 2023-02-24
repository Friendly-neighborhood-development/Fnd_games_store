package com.fnd.games_store.orders.rest;

import com.fnd.games_store.orders.dto.ValidationResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "login-service", decode404 = true)
public interface UserValidationClient {
    @RequestMapping(method = RequestMethod.POST, value = "login/v1/validate", consumes = "application/json", produces = "application/json")
    ResponseEntity<ValidationResponseDTO> validateUser(@RequestHeader("Authorization") String AuthorizationHeaderValue);
}
