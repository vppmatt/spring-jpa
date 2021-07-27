import com.multicode.config.*;
import com.multicode.domain.*;
import com.multicode.service.*;
import org.springframework.context.*;
import org.springframework.context.annotation.*;

import java.util.*;

public class MainSpringVersion {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
        CreditCardTransactionService service = applicationContext.getBean(CreditCardTransactionServiceImpl.class);

        List<CreditCardTransaction> ccTransactionList = service.getAllTransactionsForOrder("21212355");
        
        for (CreditCardTransaction ccTransaction : ccTransactionList) {
            System.out.println(ccTransaction);
        }

        service.udpateTaxRate(34, 0.19);

    }
}
