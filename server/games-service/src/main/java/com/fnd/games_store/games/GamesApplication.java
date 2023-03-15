package com.fnd.games_store.games;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.net.InetAddress;


@SpringBootApplication(exclude = {UserDetailsServiceAutoConfiguration.class})
@EnableDiscoveryClient
@EnableCaching
@EnableFeignClients
public class GamesApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(GamesApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("===================="+ InetAddress.getLocalHost().getHostAddress()+"=====================");
    }
}
