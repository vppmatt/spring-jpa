package com.allstate.payments.service;

import com.allstate.payments.data.*;
import com.allstate.payments.domain.*;
import com.allstate.payments.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import javax.transaction.*;
import java.util.*;

@Service  //Note this was @Component
@Transactional(Transactional.TxType.REQUIRED)
public class CreditCardTransactionServiceImpl implements CreditCardTransactionService{

    @Autowired // Note we're going straight to the repository now
    private CreditCardTransactionRepository repository;

    @Override
    public List<CreditCardTransaction> getAllTransactionsForOrder(String orderId) {
        return repository.findAllByOrderId(orderId);
    }

    @Override
    public List<CreditCardTransaction> getAllTransactions() {
        return repository.findAll();
    }

    public CreditCardTransaction getById(int id) {
        Optional<CreditCardTransaction> ccTrans = repository.findById(id);
        return ccTrans.orElse(null);
    }

    public List<CreditCardTransaction> getAllForAnOrder(String orderId) {
        return repository.findAllByOrderId(orderId);
    }

    public List<CreditCardTransaction> getAllForACountry(String country) {
        return repository.findAllByCountry(country);
    }

    public CreditCardTransaction saveTransaction(CreditCardTransaction ccTransaction) {
        return repository.save(ccTransaction);
    }

    @Override
    public boolean updateTaxRate(Integer transactionIdStart, Integer transactionIdEnd, Double newRate) {
//        boolean result = true;
//        for (int id = transactionIdStart; id <= transactionIdEnd; id++) {
//            boolean check = dao.setTaxRate(id, newRate);
//            if (!check) result = false;
//        }
//        return result;

        for (int id = transactionIdStart; id <= transactionIdEnd; id++) {
            Optional<CreditCardTransaction> trans = repository.findById(id);
            if (!trans.isPresent()) {
                return false;
            }
            CreditCardTransaction transaction = trans.get();
            transaction.setTaxRate(newRate);
            repository.save(transaction);
        }
        return true;
    }
}
