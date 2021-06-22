package com.allstate.payments.data;

import com.allstate.payments.domain.CreditCardTransaction;

import java.util.List;

public interface CreditCardTransactionDao {

    public List<CreditCardTransaction> getAllTransactionsForOrder(String orderId);

    public boolean setTaxRate(Integer transactionId, Double newRate);
}