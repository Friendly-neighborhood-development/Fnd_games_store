package com.fnd.games_store.login.dto;

import lombok.*;

@AllArgsConstructor
@Data
@Getter
@Setter
public class LoginResponseDTO {

    private String userId;
    private String token;

}
