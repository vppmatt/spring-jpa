package com.allstate.service;

import com.allstate.data.InvoiceData;
import com.allstate.domain.Invoice;
import com.allstate.service.InvoiceUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class InvoiceUtilitiesImpl implements InvoiceUtilities {

    @Autowired
    private InvoiceData invoiceData;

    @Override
    public void setInvoiceData(InvoiceData invoiceData) {
        this.invoiceData = invoiceData;
    }

    @Override
    public Invoice generateInvoice() {
        return new Invoice(1,1,12.34, null);
    }

    @Override
    public void payInvoice(Integer invoiceId) {
        Invoice invoice = invoiceData.findInvoice(invoiceId);
        invoice.setTotal(0.0);
        invoiceData.updateInvoice(invoice);
        System.out.println("com.allstate.domain.Invoice " + invoiceId + " has been paid");
    }

    @Override
    public List<Invoice> getInvoicesForCustomer(Integer customerId) {
        return invoiceData.getAllInvoicesForCustomer(customerId);
    }
}
