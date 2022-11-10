package com.fnd.games_store.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AuthenticationGatewayFilterFactory extends AbstractGatewayFilterFactory<AuthenticationGatewayFilterFactory.Config> {

    public AuthenticationGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {


        return (exchange, chain) -> {

            ServerHttpRequest.Builder builder = exchange.getRequest().mutate();

            log.info("=================REQUEST FILTERED================");


            return chain.filter(exchange.mutate().request(builder.build()).build());
        };
    }

    public static class Config {

    }
}
