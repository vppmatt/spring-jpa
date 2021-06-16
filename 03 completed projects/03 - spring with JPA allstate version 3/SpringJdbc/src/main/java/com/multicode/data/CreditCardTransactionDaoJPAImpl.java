package com.multicode.data;

import com.multicode.domain.CreditCardTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

//@Component
@Transactional(Transactional.TxType.REQUIRED)
public class CreditCardTransactionDaoJPAImpl implements CreditCardTransactionDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<CreditCardTransaction> getAllTransactionsForOrder(String orderId) {

        Query query = em.createQuery("Select c from CreditCardTransaction c");
        return query.getResultList();
    }

    @Override
    public boolean setTaxRate(Integer transactionId, Double newRate) {

        //later could update this to just pass in the whole transaction rather than just the id
        CreditCardTransaction transaction = em.find(CreditCardTransaction.class,transactionId);
        boolean result = false;
        if (transaction != null) {
            transaction.setTaxRate(newRate);

            try {
                em.persist(transaction);
                //should put in try catch block and return false if fails
                result = true;

            } catch (Exception e) {

            }
        }
        return result;
    }

}
