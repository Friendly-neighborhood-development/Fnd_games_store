package com.fnd.games_store.cart.configuration;

import com.fnd.games_store.cart.entity.Game;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.List;

@Configuration
public class RedisConfiguration {

    @Value("${variables.redis.host}")
    private String redisRoute;

    @Value("${variables.redis.port}")
    private int redisPort;

	@Bean
	public LettuceConnectionFactory connectionFactory() {
		  return new LettuceConnectionFactory(new RedisStandaloneConfiguration(redisRoute, redisPort));
	 }


    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory());
        return template;
    }







}