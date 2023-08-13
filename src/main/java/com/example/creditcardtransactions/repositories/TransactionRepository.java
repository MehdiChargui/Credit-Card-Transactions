package com.example.creditcardtransactions.repositories;

import com.example.creditcardtransactions.models.Transaction;
import java.io.IOException;
import java.util.List;

public interface TransactionRepository {

	List<Transaction> getAllTransactions() throws IOException;
}
