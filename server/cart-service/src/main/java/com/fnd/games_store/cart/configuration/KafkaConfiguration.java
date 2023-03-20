package com.fnd.games_store.cart.configuration;

import java.util.HashMap;
import java.util.Map;


import com.fnd.games_store.cart.dto.OrderDTO;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

@Configuration
public class KafkaConfiguration {


    @Value("${variables.kafka.bootstrap_address}")
    private String kafkaAddress;


    @Bean
    public ProducerFactory <String, OrderDTO> producerFactory(){
        Map<String,Object> kafkaConfig = new HashMap<>();
        kafkaConfig.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaAddress);
        kafkaConfig.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        kafkaConfig.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(kafkaConfig);
    }


    @Bean
    public KafkaTemplate<String,OrderDTO> kafkaTemplate(){
        return new KafkaTemplate<>(producerFactory());
    }


}
