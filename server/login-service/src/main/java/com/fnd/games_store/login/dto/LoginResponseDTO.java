package com.fnd.games_store.login.dto;

import lombok.*;

@AllArgsConstructor
@Data
@Getter
@Setter
@NoArgsConstructor
public class LoginResponseDTO {

    private String userId;
    private String token;

}
