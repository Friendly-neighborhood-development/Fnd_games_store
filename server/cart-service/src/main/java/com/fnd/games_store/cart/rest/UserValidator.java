package com.fnd.games_store.cart.rest;

import com.fnd.games_store.cart.dto.ValidationResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@FeignClient("login")
public interface UserValidator {


    @RequestMapping(method = RequestMethod.POST, value = "localhost:8082/login/v1/validate", consumes = "application/json")
    ResponseEntity<ValidationResponseDTO> validateUser(String token);

}
