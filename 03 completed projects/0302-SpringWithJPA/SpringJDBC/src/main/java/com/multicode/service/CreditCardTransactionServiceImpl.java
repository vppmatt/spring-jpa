package com.multicode.service;

import com.multicode.data.*;
import com.multicode.domain.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import javax.transaction.*;
import java.util.*;

@Component
public class CreditCardTransactionServiceImpl implements CreditCardTransactionService {

    @Autowired
    private CreditCardTransactionDao dao;

    @Override
    public List<CreditCardTransaction> getAllTransactionsForOrder(String orderId) {
        return dao.findAllByOrderId(orderId);
    }

    @Override
    public void udpateTaxRate(Integer taxCode, Double taxRate) {
        List<CreditCardTransaction> transactions = dao.findAllByTaxCode(taxCode);
        for (CreditCardTransaction ccTransaction : transactions) {
            dao.setTaxRate(ccTransaction.getId(), taxRate);
        }
    }
}
