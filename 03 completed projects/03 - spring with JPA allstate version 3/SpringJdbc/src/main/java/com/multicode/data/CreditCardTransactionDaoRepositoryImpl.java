package com.multicode.data;

import com.multicode.domain.CreditCardTransaction;
import com.multicode.repositories.CreditCardTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional(Transactional.TxType.REQUIRED)

public class CreditCardTransactionDaoRepositoryImpl implements CreditCardTransactionDao {

    @Autowired
    private CreditCardTransactionRepository repository;

    @Override
    public List<CreditCardTransaction> getAllTransactionsForOrder(String orderId) {
        return repository.findAllByOrderId(orderId);
    }

    @Override
    public boolean setTaxRate(Integer transactionId, Double newRate) {
        //later could update this to just pass in the whole transaction rather than just the id
        CreditCardTransaction transaction = repository.findById(transactionId).get();

        boolean result = false;

        transaction.setTaxRate(newRate);

        try {
            repository.save(transaction);
            //should put in try catch block and return false if fails
            result = true;

        } catch (Exception e) {

        }

        return result;
    }
}
