package com.multicode.service;

import com.multicode.domain.*;
import com.multicode.repositories.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import javax.transaction.*;
import java.util.*;

@Component
@Transactional(Transactional.TxType.REQUIRED)
public class CreditCardTransactionService {

    @Autowired
    CreditCardTransactionRepository creditCardTransactionRepository;

    Logger logger = LoggerFactory.getLogger(CreditCardTransactionRepository.class);

    public List<CreditCardTransaction> getAllTransactionsForOrder(String orderId) {
        logger.info("Running getAllTransactionsForOrder");
        logger.debug("OrderId is {}", orderId );
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
