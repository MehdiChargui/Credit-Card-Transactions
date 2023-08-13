package com.example.creditcardtransactions.controllers;

import com.example.creditcardtransactions.enums.TransactionStatus;
import com.example.creditcardtransactions.models.Transaction;
import com.example.creditcardtransactions.models.TransactionFilter;
import com.example.creditcardtransactions.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.math.BigDecimal;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

	private final TransactionService transactionService;

	@Autowired
	public TransactionController(TransactionService transactionService) {
		this.transactionService = transactionService;
	}

	@GetMapping
	public ResponseEntity<Page<Transaction>> listTransactions(
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size,
			@RequestParam(name = "amount", required = false) BigDecimal amount,
			@RequestParam(name = "merchant", required = false) String merchant,
			@RequestParam(name = "status", required = false) TransactionStatus status) throws IOException {
		try {
			
			TransactionFilter filter = new TransactionFilter();
				filter.setAmount(amount);
				filter.setMerchant(merchant);
				filter.setStatus(status);

			Pageable pageable = PageRequest.of(page, size);
			Page<Transaction> transactions = transactionService.getFilteredTransactions(filter, pageable);
			return new ResponseEntity<>(transactions, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
