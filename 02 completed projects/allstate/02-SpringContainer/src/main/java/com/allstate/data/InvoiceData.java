package com.allstate.data;

import com.allstate.domain.Invoice;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public interface InvoiceData {

    public List<Invoice> getAllInvoicesForCustomer(Long customerId) ;
    public Invoice findInvoice(Integer invoiceId) ;
    public boolean updateInvoice(Invoice invoice) ;

}
