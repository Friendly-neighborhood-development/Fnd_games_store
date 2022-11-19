package com.fnd.games_store.login.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
public class LoginResponseDTO {

    private String userId;
    private String token;

}
