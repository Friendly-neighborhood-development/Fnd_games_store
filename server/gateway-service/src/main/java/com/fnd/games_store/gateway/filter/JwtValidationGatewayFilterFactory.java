package com.fnd.games_store.gateway.filter;

import com.fnd.games_store.gateway.dto.ValidationResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class JwtValidationGatewayFilterFactory extends AbstractGatewayFilterFactory<JwtValidationGatewayFilterFactory.Config> {

    @Autowired
    private WebClient webClient;


    public JwtValidationGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {


        return (exchange, chain) -> {

            ServerHttpRequest.Builder builder = exchange.getRequest().mutate();

//            Mono<ResponseEntity> result = webClient.post().uri("localhost:8082/login/v1/validate").retrieve().bodyToMono(ResponseEntity.class);
//            result.subscribe();

//            log.info(result.toString());

            log.info(exchange.getRequest().getBody().toString());


            log.info("=================REQUEST FILTERED================");

            return chain.filter(exchange.mutate().request(builder.build()).build());
        };
    }


    public static class Config {

    }
}
