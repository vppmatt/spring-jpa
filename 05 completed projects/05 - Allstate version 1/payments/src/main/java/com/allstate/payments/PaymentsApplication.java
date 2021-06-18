package com.allstate.payments;

import com.allstate.payments.domain.*;
import com.allstate.payments.service.*;
import org.apache.catalina.core.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.*;

import java.util.*;

@SpringBootApplication
public class PaymentsApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(PaymentsApplication.class, args);

        CreditCardTransactionService service = applicationContext.getBean(CreditCardTransactionService.class);

        List<CreditCardTransaction> ccTransactionList = service.getAllTransactionsForOrder("21212355");

        for (CreditCardTransaction ccTransaction : ccTransactionList) {
            System.out.println(ccTransaction);
        }

        service.updateTaxRate(4800, 4820, 0.17);

    }

}
