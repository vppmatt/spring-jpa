package com.multicode.beans;

import com.multicode.domain.*;
import org.springframework.stereotype.*;

import java.util.*;

public interface InvoiceData {

    public List<Invoice> getAllInvoicesForCustomer(Integer customerId) ;
    public List<Invoice> getAllOverdueInvoices() ;
    public Invoice findInvoice(Integer invoiceId) ;
    public boolean updateInvoice(Invoice invoice) ;

}
