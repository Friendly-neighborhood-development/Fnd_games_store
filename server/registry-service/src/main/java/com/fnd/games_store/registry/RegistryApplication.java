package com.fnd.games_store.registry;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import java.net.InetAddress;

@SpringBootApplication
@EnableEurekaServer
public class RegistryApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(RegistryApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("===================="+ InetAddress.getLocalHost().getHostAddress()+"=====================");
    }

}
