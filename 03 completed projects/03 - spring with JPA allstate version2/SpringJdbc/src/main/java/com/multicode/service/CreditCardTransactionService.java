package com.multicode.service;

import com.multicode.domain.CreditCardTransaction;

import java.util.List;

public interface CreditCardTransactionService {

    List<CreditCardTransaction> getTransactionsByOrderId(String id);

    boolean updateTaxRate(Integer transactionIdStart, Integer transactionIdEnd, Double newTaxRate);

}
