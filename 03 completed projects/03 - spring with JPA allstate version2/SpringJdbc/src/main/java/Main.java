
import com.multicode.config.Config;
import com.multicode.domain.*;
import com.multicode.service.CreditCardTransactionService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);

        CreditCardTransactionService service = applicationContext.getBean(CreditCardTransactionService.class);

        List<CreditCardTransaction> ccTransactionList = service.getTransactionsByOrderId("21212355");

        for (CreditCardTransaction ccTransaction : ccTransactionList) {
            System.out.println(ccTransaction);
        }

        boolean result = service.updateTaxRate(1,20,.12);
        System.out.println("The update worked ? " + result);

    }
}
