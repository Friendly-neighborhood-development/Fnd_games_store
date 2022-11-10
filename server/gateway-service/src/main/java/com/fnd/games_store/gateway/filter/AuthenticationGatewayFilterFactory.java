package com.fnd.games_store.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class AuthenticationGatewayFilterFactory extends AbstractGatewayFilterFactory<AuthenticationGatewayFilterFactory.Config> {


    @Autowired
    private WebClient webClient;

    public AuthenticationGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {


        return (exchange, chain) -> {

            ServerHttpRequest.Builder builder = exchange.getRequest().mutate();

            log.info("=================REQUEST FILTERED================");

//            webClient.post().uri("localhost:8082/login/v1/validate");

            return chain.filter(exchange.mutate().request(builder.build()).build());
        };
    }


    public static class Config {

    }
}
