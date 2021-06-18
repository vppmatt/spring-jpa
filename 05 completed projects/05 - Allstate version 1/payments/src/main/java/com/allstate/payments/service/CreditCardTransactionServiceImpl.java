package com.allstate.payments.service;

import com.allstate.payments.data.*;
import com.allstate.payments.domain.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import javax.transaction.*;
import java.util.*;

@Service  //Note this was @Component
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
