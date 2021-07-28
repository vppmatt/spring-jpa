package com.multicode.service;

import com.multicode.domain.CreditCardTransaction;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CreditCardTransactionService {
    List<CreditCardTransaction> getAllTransactionsForOrder(String orderId);

    void udpateTaxRate(Integer taxCode, Double taxRate);

    List<CreditCardTransaction> getAllUSDTransactions();

    Integer updateTaxRate(String country, Double newRate);
}
