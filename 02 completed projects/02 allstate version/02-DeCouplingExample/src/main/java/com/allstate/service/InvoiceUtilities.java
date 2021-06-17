package com.allstate.service;

import com.allstate.data.InvoiceData;
import com.allstate.domain.Invoice;

import java.util.List;

public interface InvoiceUtilities {
    void setInvoiceData(InvoiceData invoiceData);

    Invoice generateInvoice();

    void payInvoice(Integer invoiceId);

    List<Invoice> getInvoicesForCustomer(Integer customerId);
}
