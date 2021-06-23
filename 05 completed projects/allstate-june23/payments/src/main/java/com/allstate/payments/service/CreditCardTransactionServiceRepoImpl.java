package com.allstate.payments.service;

import com.allstate.payments.data.CreditCardTransactionRepository;
import com.allstate.payments.domain.CreditCardTransaction;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Primary
@Transactional(Transactional.TxType.REQUIRED)
public class CreditCardTransactionServiceRepoImpl implements CreditCardTransactionService {

    @Autowired
    private CreditCardTransactionRepository repository;


    @Override
    public List<CreditCardTransaction> getAllTransactionsForOrder(String orderId) {
        return repository.findAllByOrderId(orderId);
    }

    @Override
    public boolean updateTaxRate(Integer transactionIdStart, Integer transactionIdEnd, Double newRate) {

        List<CreditCardTransaction> transactions = repository.findAllByIdGreaterThanEqualAndIdLessThanEqual(transactionIdStart, transactionIdEnd);
        for(CreditCardTransaction transaction : transactions) {
            transaction.setTaxRate(newRate);
        }
        repository.saveAll(transactions);
        return true;
    }

    @Override
    public List<CreditCardTransaction> getAllTransactions() {
        return repository.findAll();
    }

    @Override
    public CreditCardTransaction getTransactionById(Integer id) {
        CreditCardTransaction t = repository.findById(id).get();
        return t;
    }

    @Override
    public List<CreditCardTransaction> getTransactionsByCountry(String country) {
        return repository.findAllByCountry(country);
    }
}
