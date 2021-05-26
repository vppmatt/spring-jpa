package com.multicode.repositories;

import com.multicode.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Component
public interface CreditCardTransactionRepository extends JpaRepository<CreditCardTransaction, Integer> {
    public List<CreditCardTransaction> findAllByOrderId(String orderId);
    public List<CreditCardTransaction> findAllByTaxCode(Integer taxCode);
}
