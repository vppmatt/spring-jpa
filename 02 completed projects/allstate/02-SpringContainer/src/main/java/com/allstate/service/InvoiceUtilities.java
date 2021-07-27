package com.allstate.service;

import com.allstate.domain.Invoice;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public interface InvoiceUtilities {

//    void setInvoiceData(InvoiceData invoiceData);

    Invoice generateInvoice();

    void payInvoice(Integer invoiceId);

    List<Invoice> getInvoicesForCustomer(Long customerId);
}
