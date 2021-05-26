import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;

@Configuration
public class InvoiceConfigurer {

    //This is the configuration version of the class

    @Bean
    public InvoiceData invoiceData() {
        return new InvoiceDataImpl();
    }

    @Bean
    public InvoiceUtilities invoiceUtilities(@Autowired InvoiceData invoiceData) {
        InvoiceUtilities invoiceUtilities = new InvoiceUtilitiesImpl();
        invoiceUtilities.setInvoiceData(invoiceData);
        return invoiceUtilities;
    }
}
