package com.multicode.impl;

import com.multicode.beans.*;
import com.multicode.domain.*;
import org.springframework.stereotype.*;

import java.util.*;

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

    public Invoice findInvoice(Integer invoiceId) {
        return new Invoice(1,1,12.34, null);
    }

    public boolean updateInvoice(Invoice invoice) {
        return true;
    }

}
