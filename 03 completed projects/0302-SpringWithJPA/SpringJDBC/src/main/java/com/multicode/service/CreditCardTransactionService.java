package com.multicode.service;

import com.multicode.domain.CreditCardTransaction;

import java.util.List;

public interface CreditCardTransactionService {
    List<CreditCardTransaction> getAllTransactionsForOrder(String orderId);

    void udpateTaxRate(Integer taxCode, Double taxRate);
}
