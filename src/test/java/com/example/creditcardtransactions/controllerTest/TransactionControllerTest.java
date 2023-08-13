package com.example.creditcardtransactions.controllerTest;

import static org.mockito.Mockito.*;
import com.example.creditcardtransactions.controllers.TransactionController;
import com.example.creditcardtransactions.enums.TransactionStatus;
import com.example.creditcardtransactions.models.Transaction;
import com.example.creditcardtransactions.models.TransactionFilter;
import com.example.creditcardtransactions.services.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TransactionControllerTest {

    private TransactionService transactionService;
    private TransactionController transactionController;

    @BeforeEach
    void setUp() {
        transactionService = mock(TransactionService.class);
        transactionController = new TransactionController(transactionService);
    }

    @Test
    void testListTransactions_Success() throws IOException {
        // Arrange
        TransactionFilter filter = new TransactionFilter();
        List<Transaction> fakeTransactions = new ArrayList<>();
        fakeTransactions.add(new Transaction(1L,100.0,"Merchant A", TransactionStatus.APPROVED,new Date(0)));
        fakeTransactions.add(new Transaction(2L,100.0,"Merchant B", TransactionStatus.PENDING,new Date(0)));
        fakeTransactions.add(new Transaction(3L,100.0,"Merchant A", TransactionStatus.REFUSED,new Date(0)));
        Page<Transaction> fakePage = new PageImpl<>(fakeTransactions);
        when(transactionService.getFilteredTransactions(eq(filter), any(Pageable.class)))
                .thenReturn(fakePage);

        // Act
        ResponseEntity<Page<Transaction>> response = transactionController.listTransactions(0, 5, 0, null, null, "amount");

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(fakePage, response.getBody());
    }
}
