package com.multicode.service;

import com.multicode.domain.*;
import com.multicode.repositories.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import javax.transaction.*;
import java.util.*;

@Component
@Transactional(Transactional.TxType.REQUIRED)
public class CreditCardTransactionService {

    @Autowired
    CreditCardTransactionRepository creditCardTransactionRepository;

    public List<CreditCardTransaction> getAllTransactionsForOrder(String orderId) {
        return creditCardTransactionRepository.findAllByOrderId(orderId);
    }

    public void udpateTaxRate(Integer taxCode, Double taxRate) {
        List<CreditCardTransaction> transactions = creditCardTransactionRepository.findAllByTaxCode(taxCode);
        for (CreditCardTransaction ccTransaction : transactions) {
            ccTransaction.setTaxRate(taxRate);
        }
        creditCardTransactionRepository.saveAll(transactions);
    }
}
