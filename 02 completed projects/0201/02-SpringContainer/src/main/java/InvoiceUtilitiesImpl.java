import java.util.*;

public class InvoiceUtilitiesImpl implements InvoiceUtilities {

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
        System.out.println("Invoice " + invoiceId + " has been paid");
        invoiceData.updateInvoice(invoice);
    }

    @Override
    public List<Invoice> getInvoicesForCustomer(Integer customerId) {
        return invoiceData.getAllInvoicesForCustomer(customerId);
    }
}
