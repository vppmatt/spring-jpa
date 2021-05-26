package com.multicode;

import com.multicode.beans.*;
import com.multicode.domain.*;
import org.springframework.context.*;
import org.springframework.context.support.*;

public class Main {
    public static void main(String[] args) {

        //XML configuration version
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        InvoiceUtilities invoiceUtilities = applicationContext.getBean(InvoiceUtilities.class);

        Invoice invoice = invoiceUtilities.generateInvoice();
        invoiceUtilities.payInvoice(invoice.getId());

    }
}
