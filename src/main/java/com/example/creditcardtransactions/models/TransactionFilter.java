package com.example.creditcardtransactions.models;

import com.example.creditcardtransactions.enums.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionFilter {
	private BigDecimal amount;
	private String merchant;
	private TransactionStatus status;
}
