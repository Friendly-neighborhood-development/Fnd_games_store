package com.fnd.games_store.cart.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfiguration {

    @Value("${variables.redis.host}")
    private String redisRoute;

    @Value("${variables.redis.port}")
    private int redisPort;



	@Bean
	public LettuceConnectionFactory lettuceConnectionFactory() {
		  return new LettuceConnectionFactory(new RedisStandaloneConfiguration(redisRoute, redisPort));
	 }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(lettuceConnectionFactory());
        return template;
    }





}
