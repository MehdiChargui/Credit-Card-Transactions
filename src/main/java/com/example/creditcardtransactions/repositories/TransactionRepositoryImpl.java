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
	/*
	repository implementation that reads transactions from a JSON file named "transactionsMock.json"
	located in the classpath. It uses Jackson's ObjectMapper to deserialize the JSON data
	 into an array of Transaction objects.
	*/

	@Override
	public List<Transaction> getAllTransactions() throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		ClassPathResource resource = new ClassPathResource("transactionsMock.json");
		Transaction[] transactionsArray = objectMapper.readValue(resource.getInputStream(), Transaction[].class);
		return Arrays.asList(transactionsArray);
	}

}
