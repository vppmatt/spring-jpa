package com.allstate.data;

import com.allstate.data.InvoiceData;
import com.allstate.domain.Invoice;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class InvoiceDataImpl implements InvoiceData {

    /*
    All the code in this class is just dummy code to make the class compile.
    It is simulating talking to a database
     */

    public InvoiceDataImpl() {
        
    }

    public List<Invoice> getAllInvoicesForCustomer(Integer customerId) {
        return new ArrayList<>();
    }

    public List<Invoice> getAllOverdueInvoices() {
        return new ArrayList<>();
    }

    @Override
    public List<Invoice> getAllPaidInvoices() {
        return null;
    }

    public Invoice findInvoice(Integer invoiceId) {
        return new Invoice(1,1,12.34, null);
    }

    public boolean updateInvoice(Invoice invoice) {
        return true;
    }

}
