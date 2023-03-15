package com.fnd.games_store.login;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.core.context.SecurityContextHolder;
import sun.tools.jar.CommandLine;

import java.net.InetAddress;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class LoginApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(LoginApplication.class, args);

    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("===================="+ InetAddress.getLocalHost().getHostAddress()+"=====================");
    }

}
