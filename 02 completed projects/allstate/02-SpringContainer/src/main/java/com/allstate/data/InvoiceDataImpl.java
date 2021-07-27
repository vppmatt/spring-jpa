package com.allstate.data;

import com.allstate.domain.Customer;
import com.allstate.domain.Invoice;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@Component
public class InvoiceDataImpl implements InvoiceData {

    @PersistenceContext
    private EntityManager entityManager;

    public InvoiceDataImpl() {

    }

    public List<Invoice> getAllInvoicesForCustomer(Long customerId) {
        Customer customer = entityManager.find(Customer.class, customerId);
        return customer.getInvoices();
    }

    public Invoice findInvoice(Integer invoiceId) {
        return entityManager.find(Invoice.class, invoiceId);
    }

    public boolean updateInvoice(Invoice invoice) {
        entityManager.persist(invoice);
        return true;
    }

}
