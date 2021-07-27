package com.allstate.service;

import com.allstate.data.InvoiceData;
import com.allstate.domain.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class InvoiceUtilitiesImpl implements InvoiceUtilities {

    @Autowired
    private InvoiceData invoiceData;

    @Override
    public Invoice generateInvoice() {
        return null;
    }

    @Override
    public void payInvoice(Integer invoiceId) {
        Invoice invoice = invoiceData.findInvoice(invoiceId);
        invoice.setTotal(0.0);
        invoiceData.updateInvoice(invoice);
        System.out.println("com.allstate.domain.Invoice " + invoiceId + " has been paid");
    }

    @Override
    public List<Invoice> getInvoicesForCustomer(Long customerId) {
        return invoiceData.getAllInvoicesForCustomer(customerId);
    }
}
