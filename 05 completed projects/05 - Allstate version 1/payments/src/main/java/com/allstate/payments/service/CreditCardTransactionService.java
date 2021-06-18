package com.allstate.payments.service;

import com.allstate.payments.domain.*;

import java.util.*;

public interface CreditCardTransactionService {

    public List<CreditCardTransaction> getAllTransactionsForOrder(String orderId);

    public boolean updateTaxRate(Integer transactionIdStart, Integer transactionIdEnd, Double newRate);
}
