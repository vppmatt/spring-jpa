package com.multicode.data;

import com.multicode.domain.CreditCardTransaction;

import java.util.List;

public interface CreditCardTransactionDao {

    List<CreditCardTransaction> getTransactionsByOrderNumber(String orderId);
    boolean setTaxRate(Integer transId, Double newRate);
}
