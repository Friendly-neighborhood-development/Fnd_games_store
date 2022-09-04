package com.fnd.games_store.gateway;

import com.fnd.games_store.gateway.feign.LoginServiceClient;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@Slf4j
public class GatewayApplication implements CommandLineRunner {


    @Autowired
    LoginServiceClient loginClient;

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class,args);
    }

    @Override
    public void run(String... args) throws Exception {

//        loginClient.validateUserByToken();
        log.info( loginClient.validateUserByToken().toString());
    }
}
