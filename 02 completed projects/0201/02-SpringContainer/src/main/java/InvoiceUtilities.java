import org.springframework.stereotype.*;

import java.util.*;

@Component
public interface InvoiceUtilities {

    void setInvoiceData(InvoiceData invoiceData);

    Invoice generateInvoice();

    void payInvoice(Integer invoiceId);

    List<Invoice> getInvoicesForCustomer(Integer customerId);
}
