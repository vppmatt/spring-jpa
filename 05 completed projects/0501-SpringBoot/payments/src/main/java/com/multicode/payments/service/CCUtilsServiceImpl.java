package com.multicode.payments.service;

import com.multicode.payments.data.*;
import com.multicode.payments.domain.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class CCUtilsServiceImpl implements CCUtilsService {

    @Autowired
    private CreditCardTransactionRepository ccTransactionRepository;

    public List<CreditCardTransaction> getAllTransactions() {
        return ccTransactionRepository.findAll();
    }
}
