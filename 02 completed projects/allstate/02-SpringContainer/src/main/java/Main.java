import com.allstate.config.InvoiceConfigurer;
import com.allstate.domain.Invoice;
import com.allstate.service.InvoiceUtilities;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(InvoiceConfigurer.class);
        InvoiceUtilities invoiceUtilities = context.getBean(InvoiceUtilities.class);

        //NOW WE CAN USE THE METHODS OF THE INVOICE UTILITIES CLASS
        List<Invoice> invoices = invoiceUtilities.getInvoicesForCustomer(80L);
        System.out.println(invoices);
    }
}
