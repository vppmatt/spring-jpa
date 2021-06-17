package com.multicode.data;

import com.multicode.domain.CreditCardTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional(Transactional.TxType.REQUIRED)
public class CreditCardTransactionDaoJPAImpl implements CreditCardTransactionDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<CreditCardTransaction> getTransactionsByOrderNumber(String orderId) {

        Query query = em.createQuery("SELECT c FROM CreditCardTransaction c where c.orderId = " + orderId);
//        TypedQuery<CreditCardTransaction> query = em
//                .createQuery("SELECT c FROM CreditCardTransaction c where c.orderId = " + orderId,
//                        CreditCardTransaction.class);

        return query.getResultList();
    }

    @Override
    public boolean setTaxRate(Integer transId, Double newRate) {

        CreditCardTransaction transaction = em.find(CreditCardTransaction.class, transId);

        if(transaction != null) {
            transaction.setTaxRate(newRate);
            em.persist(transaction);
            return true;
        }

        return false;

    }

}
