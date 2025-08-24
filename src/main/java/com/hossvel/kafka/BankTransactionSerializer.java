package com.hossvel.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hossvel.model.BankTransaction;
import jakarta.enterprise.context.ApplicationScoped;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

@ApplicationScoped
public class BankTransactionSerializer implements Serializer<BankTransaction> {
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public byte[] serialize(String topic, BankTransaction data) {
        try {
            return mapper.writeValueAsBytes(data);
        } catch (Exception e) {
            throw new SerializationException("Error serializing BankTransaction", e);
        }
    }
}