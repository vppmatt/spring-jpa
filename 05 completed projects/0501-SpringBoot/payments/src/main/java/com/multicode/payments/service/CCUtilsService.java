package com.multicode.payments.service;

import com.multicode.payments.domain.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public interface CCUtilsService {

    public List<CreditCardTransaction> getAllTransactions();
}
