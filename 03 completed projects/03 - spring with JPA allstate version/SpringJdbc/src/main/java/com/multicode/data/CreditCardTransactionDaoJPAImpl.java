package com.multicode.data;

import com.multicode.domain.CreditCardTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
public class CreditCardTransactionDaoJPAImpl implements CreditCardTransactionDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<CreditCardTransaction> getAllTransactionsForOrder(String orderId) {

        Query query = em.createQuery("Select c from CreditCardTransaction c");
        return query.getResultList();
    }
}
