package com.allstate.payments.service;

import com.allstate.payments.data.CreditCardTransactionDao;
import com.allstate.payments.domain.CreditCardTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional(Transactional.TxType.REQUIRED)
public class CreditCardTransactionServiceImpl implements CreditCardTransactionService{

    @Autowired
    private CreditCardTransactionDao dao;

    @Override
    public List<CreditCardTransaction> getAllTransactionsForOrder(String orderId) {
        return dao.getAllTransactionsForOrder(orderId);
    }

    @Override
    public boolean updateTaxRate(Integer transactionIdStart, Integer transactionIdEnd, Double newRate) {
        boolean result = true;
        for (int id = transactionIdStart; id <= transactionIdEnd; id++) {
            boolean check = dao.setTaxRate(id, newRate);
            if (!check) result = false;
        }
        return result;
    }
}
