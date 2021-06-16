package com.multicode.repositories;

import com.multicode.domain.CreditCardTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreditCardTransactionRepository extends JpaRepository<CreditCardTransaction, Integer> {
    List<CreditCardTransaction> findAllByOrderId(String orderId);

}
