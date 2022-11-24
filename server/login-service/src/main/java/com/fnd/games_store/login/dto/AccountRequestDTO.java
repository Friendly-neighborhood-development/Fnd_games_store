package com.fnd.games_store.login.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccountRequestDTO {

    private String username;

    private String password;

}
