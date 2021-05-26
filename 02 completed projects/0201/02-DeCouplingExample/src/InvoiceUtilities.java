import java.util.*;

public class InvoiceUtilities implements InvoiceUtilitiesInterface {

    private InvoiceDataInterface invoiceData;

    @Override
    public void setInvoiceData(InvoiceDataInterface invoiceData) {
        this.invoiceData = invoiceData;
    }

    @Override
    public Invoice generateInvoice() {
        return new Invoice();
    }

    @Override
    public void payInvoice(Integer invoiceId) {
        Invoice invoice = invoiceData.findInvoice(invoiceId);
        invoice.setTotal(0.0);
        invoiceData.updateInvoice(invoice);
    }

    @Override
    public List<Invoice> getInvoicesForCustomer(Integer customerId) {
        return invoiceData.getAllInvoicesForCustomer(customerId);
    }
}
