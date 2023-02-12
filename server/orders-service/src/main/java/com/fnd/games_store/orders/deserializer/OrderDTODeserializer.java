package com.fnd.games_store.orders.deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.fnd.games_store.orders.dto.OrderDTO;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;


import java.util.Map;


public class OrderDTODeserializer implements Deserializer<OrderDTO> {


    private final ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        Deserializer.super.configure(configs, isKey);
    }

    @Override
    public OrderDTO deserialize(String topic, byte[] data) {
        try {
            if (data == null){
                return null;
            }
            return objectMapper.readValue(new String(data, "UTF-8"), OrderDTO.class);
        } catch (Exception e) {
            throw new SerializationException("Error when deserializing byte[] to OrderDTO");
        }
    }

    @Override
    public OrderDTO deserialize(String topic, Headers headers, byte[] data) {
        return Deserializer.super.deserialize(topic, headers, data);
    }

    @Override
    public void close() {
        Deserializer.super.close();
    }
}
