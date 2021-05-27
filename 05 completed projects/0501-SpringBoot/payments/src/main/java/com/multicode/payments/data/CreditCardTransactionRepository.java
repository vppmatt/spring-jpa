package com.multicode.payments.data;

import com.multicode.payments.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface CreditCardTransactionRepository extends JpaRepository<CreditCardTransaction, Integer> {
}
