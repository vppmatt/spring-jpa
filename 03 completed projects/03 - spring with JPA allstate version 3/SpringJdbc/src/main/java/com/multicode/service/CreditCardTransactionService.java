package com.multicode.service;

import com.multicode.domain.CreditCardTransaction;

import java.util.List;

public interface CreditCardTransactionService {

    public List<CreditCardTransaction> getAllTransactionsForOrder(String orderId);

    public boolean updateTaxRate(Integer transactionIdStart, Integer transactionIdEnd, Double newRate);
}

