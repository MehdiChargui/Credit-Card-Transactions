package com.example.creditcardtransactions.services;

import com.example.creditcardtransactions.models.Transaction;
import com.example.creditcardtransactions.models.TransactionFilter;
import com.example.creditcardtransactions.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Page<Transaction> getFilteredTransactions(TransactionFilter transactionFilter, Pageable pageable) throws IOException {
        // All transactions
        List<Transaction> transactions = transactionRepository.getAllTransactions();

        // filter list by 'Merchant' & 'Status' & 'Amount'
        if(transactionFilter != null) {
            if (transactionFilter.getMerchant() != null) {
                transactions = transactions.stream()
                        .filter(transaction -> transaction.getMerchant().equals(transactionFilter.getMerchant()))
                        .collect(Collectors.toList());
            }
            if (transactionFilter.getStatus() != null) {
                transactions = transactions.stream()
                        .filter(transaction -> transaction.getStatus().equals(transactionFilter.getStatus()))
                        .collect(Collectors.toList());
            }
            if (transactionFilter.getAmount() != null) {
                transactions = transactions.stream()
                        .filter(transaction -> transaction.getAmount()==transactionFilter.getAmount())
                        .collect(Collectors.toList());
            }
        }

        // Convert the filtered transactions list to a Page
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Transaction> currentPageTransactions;

        if (transactions.size() < startItem) {
            currentPageTransactions = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, transactions.size());
            currentPageTransactions = transactions.subList(startItem, toIndex);
        }

        return new PageImpl<>(currentPageTransactions, pageable, transactions.size());
    }
}
