package com.example.creditcardtransactions.models;

import com.example.creditcardtransactions.enums.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
	private Long id;
	private BigDecimal amount;
	private String merchant;
	private TransactionStatus status;
	private Date date;
}
