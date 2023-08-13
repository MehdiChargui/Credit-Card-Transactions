package com.example.creditcardtransactions.models;

import com.example.creditcardtransactions.enums.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionFilter {
	private double amount;
	private String merchant;
	private TransactionStatus status;
}
