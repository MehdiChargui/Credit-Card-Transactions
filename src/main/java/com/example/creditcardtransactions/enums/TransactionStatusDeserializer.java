package com.example.creditcardtransactions.enums;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class TransactionStatusDeserializer extends JsonDeserializer<TransactionStatus> {

    @Override
    public TransactionStatus deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String value = p.getValueAsString().toLowerCase();
        return TransactionStatus.valueOf(value.toUpperCase());
    }
}
