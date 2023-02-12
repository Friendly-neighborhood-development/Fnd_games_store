package com.fnd.games_store.cart.configuration;

import java.util.HashMap;
import java.util.Map;

import com.fnd.games_store.cart.dto.OrderDTO;
import com.fnd.games_store.cart.serializer.OrderDTOSerializer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
@Configuration
public class KafkaConfiguration {


    @Value("${variables.kafka.port}")
    private int kafkaPort;


    @Bean
    public ProducerFactory <String, OrderDTO> producerFactory(){
        Map<String,Object> kafkaConfig = new HashMap<>();
        kafkaConfig.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        kafkaConfig.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        kafkaConfig.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, OrderDTOSerializer.class);
        return new DefaultKafkaProducerFactory<>(kafkaConfig);
    }


    @Bean
    public KafkaTemplate<String,OrderDTO> kafkaTemplate(){
        return new KafkaTemplate<>(producerFactory());
    }


}
