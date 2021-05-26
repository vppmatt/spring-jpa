import org.springframework.context.*;
import org.springframework.context.annotation.*;

public class Main {
    public static void main(String[] args) {

        //Regular Java version
        InvoiceData invoiceData = new InvoiceDataImpl();
        InvoiceUtilities invoiceUtilities = new InvoiceUtilitiesImpl();
        invoiceUtilities.setInvoiceData(invoiceData);

        Invoice invoice = invoiceUtilities.generateInvoice();
        invoiceUtilities.payInvoice(invoice.getId());

    }
}
