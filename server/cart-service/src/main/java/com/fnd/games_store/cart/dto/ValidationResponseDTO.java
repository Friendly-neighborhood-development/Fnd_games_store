package com.fnd.games_store.cart.dto;


import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ValidationResponseDTO {

    private Boolean isTokenValid;


}
