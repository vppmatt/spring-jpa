package com.multicode.data;

import com.multicode.domain.*;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.*;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.*;

@Component
@Transactional
@Primary
public class CreditCardTransactionDaoHibernateImpl implements CreditCardTransactionDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<CreditCardTransaction> findAll() {
        TypedQuery<CreditCardTransaction> query =  entityManager.createQuery("SELECT T from CreditCardTransaction T", CreditCardTransaction.class);
        return query.getResultList();
    }

    @Override
    public List<CreditCardTransaction> findAllByOrderId(String orderId) {
        TypedQuery<CreditCardTransaction> query =  entityManager.createQuery("SELECT T from CreditCardTransaction T where T.orderId = :orderId", CreditCardTransaction.class);
        query.setParameter("orderId", orderId);
        return query.getResultList();

    }

    @Override
    public List<CreditCardTransaction> findAllByTaxCode(Integer taxCode) {
        TypedQuery<CreditCardTransaction> query = entityManager.createQuery("SELECT T from CreditCardTransaction T where T.taxCode = :taxCode", CreditCardTransaction.class);
        query.setParameter("taxCode", taxCode);
        return query.getResultList();
    }

    @Override
    public boolean setTaxRate(Integer transactionId, Double newRate) {

        //later could update this to just pass in the whole transaction rather than just the id
        CreditCardTransaction transaction = entityManager
                .createQuery("Select T from CreditCardTransaction  T where T.id = :id", CreditCardTransaction.class)
                .setParameter("id", transactionId)
                .getSingleResult();
        transaction.setTaxRate(newRate);

        entityManager.persist(transaction);


        //should put in try catch block and return false if fails
        return true;

    }

    @Override
    public void updateCCTransaction(CreditCardTransaction trans) {
        CreditCardTransaction existingTrans = entityManager.find(CreditCardTransaction.class, trans.getId());
        existingTrans.setAmount(trans.getAmount());
        entityManager.persist(existingTrans);
    }
}
