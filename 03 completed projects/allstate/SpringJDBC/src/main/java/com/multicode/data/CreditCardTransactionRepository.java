package com.multicode.data;

import com.multicode.domain.CreditCardTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditCardTransactionRepository extends JpaRepository<CreditCardTransaction,Integer> {

    List<CreditCardTransaction> findAllByCurrency(String currency);
    List<CreditCardTransaction> findAllByCountry(String country);

}
