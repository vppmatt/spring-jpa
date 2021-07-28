package com.multicode.service;

import com.multicode.data.*;
import com.multicode.domain.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import javax.swing.text.html.Option;
import javax.transaction.*;
import java.util.*;

@Service
@Transactional(value = Transactional.TxType.REQUIRED, rollbackOn = {NullPointerException.class})
public class CreditCardTransactionServiceImpl implements CreditCardTransactionService {

    @Autowired
    private CreditCardTransactionDao dao;

    @Autowired
    private CreditCardTransactionRepository repository;

    private void testingRepositories() {

        CreditCardTransaction trans = repository.getById(123);
        Optional<CreditCardTransaction> trans2 = repository.findById(123);
        System.out.println(trans);
    }

    @Override
    public List<CreditCardTransaction> getAllTransactionsForOrder(String orderId) {
        testingRepositories();
        return dao.findAllByOrderId(orderId);
    }

    @Override
    public void udpateTaxRate(Integer taxCode, Double taxRate) {
        List<CreditCardTransaction> transactions = dao.findAllByTaxCode(taxCode);
        for (CreditCardTransaction ccTransaction : transactions) {
            dao.setTaxRate(ccTransaction.getId(), taxRate);
        }
    }

    @Override
    public List<CreditCardTransaction> getAllUSDTransactions() {
        return repository.findAllByCurrency("USD");
    }

    @Override
    public Integer updateTaxRate(String country, Double newRate) {
        List<CreditCardTransaction> transactions = repository.findAllByCountry(country);
        for(CreditCardTransaction trans : transactions) {
            trans.setTaxRate(newRate);
        }
        repository.saveAll(transactions);
        return transactions.size();
    }
}
