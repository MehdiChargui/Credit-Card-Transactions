package com.example.creditcardtransactions.repositories;

import com.example.creditcardtransactions.models.Transaction;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository {

	@Override
	public List<Transaction> getAllTransactions() throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		ClassPathResource resource = new ClassPathResource("transactionsMock.json");
		Transaction[] transactionsArray = objectMapper.readValue(resource.getInputStream(), Transaction[].class);
		return Arrays.asList(transactionsArray);
	}

}
