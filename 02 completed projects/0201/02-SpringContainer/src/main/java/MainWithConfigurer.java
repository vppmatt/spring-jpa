import org.springframework.context.*;
import org.springframework.context.annotation.*;

public class MainWithConfigurer {
    public static void main(String[] args) {

        //Configurer class version
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(InvoiceConfigurer.class);
        InvoiceUtilities invoiceUtilities = applicationContext.getBean(InvoiceUtilities.class);

        Invoice invoice = invoiceUtilities.generateInvoice();
        invoiceUtilities.payInvoice(invoice.getId());

    }
}
