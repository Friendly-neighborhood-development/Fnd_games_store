package com.fnd.games_store.games.rest;


import com.fnd.games_store.games.dto.ValidationResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "login-service", decode404 = true)
public interface AuthorityValidationClient {


    @RequestMapping(method = RequestMethod.POST, value = "login/v1/validation/authority", consumes = "application/json", produces = "application/json")
    ResponseEntity<ValidationResponseDTO> validateUserWithAuthority(@RequestHeader("Authorization") String AuthorizationHeaderValue);

}
