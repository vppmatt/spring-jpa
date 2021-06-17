package com.allstate.data;

import com.allstate.domain.Invoice;

import java.util.ArrayList;
import java.util.List;

public interface InvoiceData {
    public List<Invoice> getAllInvoicesForCustomer(Integer customerId);

    public List<Invoice> getAllOverdueInvoices();

    public List<Invoice> getAllPaidInvoices();

    public Invoice findInvoice(Integer invoiceId);

    public boolean updateInvoice(Invoice invoice);
}
