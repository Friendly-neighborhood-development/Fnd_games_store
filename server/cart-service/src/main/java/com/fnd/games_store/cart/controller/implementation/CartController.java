package com.fnd.games_store.cart.controller.implementation;

import com.fnd.games_store.cart.controller.CartCrudController;
import com.fnd.games_store.cart.dto.CartRequestDTO;
import com.fnd.games_store.cart.dto.CartResponseDTO;
import com.fnd.games_store.cart.dto.GameRequestDTO;
import com.fnd.games_store.cart.dto.GameResponseDTO;
import com.fnd.games_store.cart.service.CartCrudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@CrossOrigin(value = "localhost:3000")
@Slf4j
public class CartController implements CartCrudController {


    private final CartCrudService service;

    @Autowired
    public CartController(CartCrudService service) {
        this.service = service;
    }

    @Override
    @PostMapping("/v1/update")
    public ResponseEntity<CartResponseDTO> updateCart(@RequestBody CartRequestDTO cartRequestDTO) {
        service.updateCart(cartRequestDTO);
        return ResponseEntity.ok(new CartResponseDTO(cartRequestDTO));
    }

    @Override
    @PostMapping("/v1/getContent")
    public ResponseEntity<Set<GameResponseDTO>> getCartContent(@RequestBody GameRequestDTO gameRequestDTO) {
        return ResponseEntity.ok(service.getCartContent(gameRequestDTO.getUserId()));
    }
}
