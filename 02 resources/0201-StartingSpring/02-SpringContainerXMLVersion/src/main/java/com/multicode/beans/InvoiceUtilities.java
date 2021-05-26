package com.multicode.beans;

import com.multicode.domain.*;

import java.util.*;

public interface InvoiceUtilities {

    void setInvoiceData(InvoiceData invoiceData);

    Invoice generateInvoice();

    void payInvoice(Integer invoiceId);

    List<Invoice> getInvoicesForCustomer(Integer customerId);
}
