package com.fnd.games_store.cart.test.utilities;

import com.fnd.games_store.cart.entity.Cart;
import com.fnd.games_store.cart.entity.Game;
import com.fnd.games_store.cart.repository.CartRepository;
import com.redis.testcontainers.RedisContainer;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class RepositoryTestUtilities {

    @Container
    protected static final RedisContainer REDIS_CONTAINER = new RedisContainer(DockerImageName.parse("redis:5.0.3-alpine")).withExposedPorts(6379);

    @DynamicPropertySource
    protected static void registerRedisProperties(DynamicPropertyRegistry registry) {
        registry.add("variables.redis.host", REDIS_CONTAINER::getHost);
        registry.add("variables.redis.port", () -> REDIS_CONTAINER.getMappedPort(6379)
                .toString());
    }

    @Autowired
    protected CartRepository repository;

    protected String userId = "user_1";


    protected List<Game> testCartGameData= new ArrayList<>();

    protected Cart testCart = new Cart();

    protected RepositoryTestUtilities() {

    }

    protected Game createTestGameEntity(String differenceParameter){
        Game game = new Game();
        game.setId("id"+ differenceParameter);
        game.setName("name" + differenceParameter);
        game.setReleaseDate("date" + differenceParameter);
        game.setPrice(BigDecimal.valueOf(1000));
        game.setDiscount(BigDecimal.valueOf(200));
        game.setDescription("description" + differenceParameter);
        game.setBase64Image("image" + differenceParameter);
        return game;
    }

    @AfterEach
    protected void afterTestCleanup(){
        repository.deleteAll();
    }








}
