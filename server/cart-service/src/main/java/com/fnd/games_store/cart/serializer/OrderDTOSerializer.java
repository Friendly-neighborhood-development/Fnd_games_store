package com.fnd.games_store.cart.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fnd.games_store.cart.dto.OrderDTO;
import org.apache.commons.lang.SerializationException;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;


public class OrderDTOSerializer implements Serializer<OrderDTO> {


    private final ObjectMapper objectMapper = new ObjectMapper();




    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        Serializer.super.configure(configs, isKey);
    }

    @Override
    public byte[] serialize(String topic, OrderDTO data) {

        try {
            if (data == null){
                return null;
            }
            return objectMapper.writeValueAsBytes(data);
        } catch (Exception e) {
            throw new SerializationException("Error when serializing MessageDto to byte[]");
        }
    }

    @Override
    public byte[] serialize(String topic, Headers headers, OrderDTO data) {
        return Serializer.super.serialize(topic, headers, data);
    }

    @Override
    public void close() {
        Serializer.super.close();
    }
}
