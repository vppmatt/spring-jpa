import org.springframework.context.*;
import org.springframework.context.annotation.*;

public class MainWithAnnotations {
    public static void main(String[] args) {

        //Annotations version = same as Configuration version
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(InvoiceConfigurer.class);
        InvoiceUtilities invoiceUtilities = applicationContext.getBean(InvoiceUtilities.class);

        Invoice invoice = invoiceUtilities.generateInvoice();
        invoiceUtilities.payInvoice(invoice.getId());

    }
}
