package com.multicode.service;

import com.multicode.domain.*;
import com.multicode.dto.*;
import com.multicode.repositories.*;
import org.modelmapper.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import javax.transaction.*;
import java.util.*;
import java.util.stream.*;

@Component
@Transactional(Transactional.TxType.REQUIRED)
public class CreditCardTransactionService {

    @Autowired
    CreditCardTransactionRepository creditCardTransactionRepository;

    public List<CreditCardTransactionDTO> getAllTransactionsForOrder(String orderId) {
        ModelMapper modelMapper = new ModelMapper();
        List<CreditCardTransaction> transactions = creditCardTransactionRepository.findAllByOrderId(orderId);

        //This is a modern Java 8 Lambda syntax version
        //List<CreditCardTransactionDTO> transactionDTOs = transactions.stream().
        // map( trans -> modelMapper.map(trans, CreditCardTransactionDTO.class)).
        // collect(Collectors.toList());

        //This is the standard Java OO version
        List<CreditCardTransactionDTO> transactionDTOs = new ArrayList<>();
        for (CreditCardTransaction trans : transactions) {
            transactionDTOs.add(modelMapper.map(trans, CreditCardTransactionDTO.class));
        }

        return transactionDTOs;
    }

    public void udpateTaxRate(Integer taxCode, Double taxRate) {
        List<CreditCardTransaction> transactions = creditCardTransactionRepository.findAllByTaxCode(taxCode);
        for (CreditCardTransaction ccTransaction : transactions) {
            ccTransaction.setTaxRate(taxRate);
        }
        creditCardTransactionRepository.saveAll(transactions);
    }
}
