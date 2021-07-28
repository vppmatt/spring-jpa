package com.multicode.data;

import com.multicode.domain.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface CreditCardTransactionDao {
    public List<CreditCardTransaction> findAll();

    public List<CreditCardTransaction> findAllByOrderId(String orderId);

    public List<CreditCardTransaction> findAllByTaxCode(Integer taxCode);

    public boolean setTaxRate(Integer transactionId, Double newRate);

    public void updateCCTransaction(CreditCardTransaction trans);
}
