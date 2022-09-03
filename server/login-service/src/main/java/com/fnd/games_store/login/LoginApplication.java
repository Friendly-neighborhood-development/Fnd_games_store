package com.fnd.games_store.login;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.context.SecurityContextHolder;

@SpringBootApplication

public class LoginApplication {
    public static void main(String[] args) {
        SpringApplication.run(LoginApplication.class, args);

    }
}
