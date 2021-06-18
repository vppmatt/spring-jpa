package com.allstate.payments.data;

import com.allstate.payments.domain.*;

import java.util.*;

public interface CreditCardTransactionDao {

    public List<CreditCardTransaction> getAllTransactionsForOrder(String orderId);

    public boolean setTaxRate(Integer transactionId, Double newRate);
}
