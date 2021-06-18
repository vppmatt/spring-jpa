package com.allstate.payments.repository;

import com.allstate.payments.domain.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface CreditCardTransactionRepository extends JpaRepository<CreditCardTransaction, Integer> {
    List<CreditCardTransaction> findAllByOrderId(String orderId);

}
