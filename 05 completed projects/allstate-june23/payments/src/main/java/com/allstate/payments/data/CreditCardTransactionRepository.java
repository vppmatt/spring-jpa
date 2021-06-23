package com.allstate.payments.data;

import com.allstate.payments.domain.CreditCardTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditCardTransactionRepository
        extends JpaRepository<CreditCardTransaction, Integer> {

    public List<CreditCardTransaction> findAllByOrderId(String orderId);
    public List<CreditCardTransaction> findAllByCountry(String country);
    public List<CreditCardTransaction> findAllByIdGreaterThanEqualAndIdLessThanEqual(Integer idStart, Integer idEnd);

}
