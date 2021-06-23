package com.allstate.payments.control;

import com.allstate.payments.domain.CreditCardTransaction;
import com.allstate.payments.service.CreditCardTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CCTransactionsController {

    @Autowired
    private CreditCardTransactionService service;

    @GetMapping("/api/transaction")
    public List<CreditCardTransaction> getTransactions(
            @RequestParam(value = "orderId", required = false)  String orderId,
                    @RequestParam(value = "country", required = false) String country) {

        if(orderId != null) {
            return service.getAllTransactionsForOrder(orderId);
        } else if (country != null) {
            return service.getTransactionsByCountry(country);
        } else {
            return service.getAllTransactions();
        }
    }

    //TODO: why isn't this working?
    @GetMapping(value = "/api/transaction/{id}", produces ={MediaType.APPLICATION_JSON_VALUE})
    public CreditCardTransaction getTransactionById( @PathVariable Integer id) {
        return service.getTransactionById(id);
    }


}
