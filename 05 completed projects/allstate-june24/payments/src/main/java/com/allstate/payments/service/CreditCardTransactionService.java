package com.allstate.payments.service;

import com.allstate.payments.domain.CreditCardTransaction;

import java.util.List;

public interface CreditCardTransactionService {

    public List<CreditCardTransaction> getAllTransactionsForOrder(String orderId);
    public List<CreditCardTransaction> getTransactionsByCountry(String country);

    public boolean updateTaxRate(Integer transactionIdStart, Integer transactionIdEnd, Double newRate);

    public List<CreditCardTransaction> getAllTransactions();

    public CreditCardTransaction getTransactionById(Integer id);

    public Integer addTransaction(CreditCardTransaction transaction);

    public void updateTransaction(Integer id, CreditCardTransaction updatedTransaction);

}

