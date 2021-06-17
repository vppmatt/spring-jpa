package com.multicode.service;

import com.multicode.data.CreditCardTransactionDao;
import com.multicode.domain.CreditCardTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional(Transactional.TxType.REQUIRED)
public class CreditCardTransactionServiceImpl implements CreditCardTransactionService{

    @Autowired
    private CreditCardTransactionDao dao;

    @Override
    public List<CreditCardTransaction> getTransactionsByOrderId(String id) {
        return dao.getTransactionsByOrderNumber(id);
    }

    @Override
    public boolean updateTaxRate(Integer transactionIdStart, Integer transactionIdEnd, Double newTaxRate) {
        boolean didItWork = true;
        for (int i = transactionIdStart; i <= transactionIdEnd; i++) {
            boolean check = dao.setTaxRate(i, newTaxRate);
            if (!check) didItWork = false;
        }
        return didItWork;
    }
}
