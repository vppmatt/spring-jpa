package com.multicode.data;

import com.multicode.domain.CreditCardTransaction;

import java.util.List;

public interface CreditCardTransactionDao {

    public List<CreditCardTransaction> getAllTransactionsForOrder(String orderId);

    public boolean setTaxRate(Integer transactionId, Double newRate);
}
