import org.springframework.stereotype.*;

import java.util.*;

@Component
public interface InvoiceData {

    public List<Invoice> getAllInvoicesForCustomer(Integer customerId) ;
    public List<Invoice> getAllOverdueInvoices() ;
    public Invoice findInvoice(Integer invoiceId) ;
    public boolean updateInvoice(Invoice invoice) ;

}
