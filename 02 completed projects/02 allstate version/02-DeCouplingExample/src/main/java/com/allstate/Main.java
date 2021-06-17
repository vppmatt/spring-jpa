package com.allstate;

import com.allstate.data.InvoiceData;
import com.allstate.data.InvoiceDataImpl;
import com.allstate.domain.Invoice;
import com.allstate.service.InvoiceUtilities;
import com.allstate.service.InvoiceUtilitiesImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

//        InvoiceData invoiceData = new InvoiceDataImpl();
//        InvoiceUtilities invoiceUtilities = new InvoiceUtilitiesImpl();
//        invoiceUtilities.setInvoiceData(invoiceData);

        ApplicationContext spring = new AnnotationConfigApplicationContext(InvoiceConfigurer.class);
        InvoiceUtilities invoiceUtilities = spring.getBean(InvoiceUtilities.class);


        //NOW WE CAN USE THE METHODS OF THE INVOICE UTILITIES CLASS

        Invoice invoice = invoiceUtilities.generateInvoice();
        invoiceUtilities.payInvoice(invoice.getId());
    }
}
