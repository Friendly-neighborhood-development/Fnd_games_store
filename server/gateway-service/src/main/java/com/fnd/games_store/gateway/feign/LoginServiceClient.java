package com.fnd.games_store.gateway.feign;


import com.fnd.games_store.gateway.dto.ValidationRequestDTO;
import com.fnd.games_store.gateway.dto.ValidationResponseDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@FeignClient(name = "login-service")
public interface LoginServiceClient {

    @RequestMapping(method = RequestMethod.POST, value = "/validate", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ValidationResponseDTO validateUserByToken(@RequestBody ValidationRequestDTO userValidationRequestDTO);

}
