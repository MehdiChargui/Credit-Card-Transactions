package com.example.creditcardtransactions.services;

import com.example.creditcardtransactions.models.Transaction;
import com.example.creditcardtransactions.models.TransactionFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.IOException;



public interface TransactionService {
    public Page<Transaction> getFilteredTransactions (TransactionFilter transactionFilter, Pageable pageable) throws IOException;
}
