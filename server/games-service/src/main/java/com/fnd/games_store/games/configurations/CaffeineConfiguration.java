package com.fnd.games_store.games.configurations;


import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class CaffeineConfiguration {

    @Bean
    public CaffeineCacheManager caffeineCacheManager(){
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        cacheManager.setCaffeine(caffeineCache());
        return cacheManager;
    }

    public Caffeine<Object, Object> caffeineCache(){
        return Caffeine.newBuilder().
                initialCapacity(10).
                maximumSize(100).
                expireAfterWrite(60, TimeUnit.SECONDS);
    }


}
