package com.example.creditcardtransactions.enums;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = TransactionStatusDeserializer.class)

public enum TransactionStatus {
    APPROVED, REFUSED, PENDING
}
