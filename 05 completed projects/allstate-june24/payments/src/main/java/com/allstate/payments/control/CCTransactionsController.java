package com.allstate.payments.control;

import com.allstate.payments.domain.CreditCardTransaction;
import com.allstate.payments.service.CreditCardTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@CrossOrigin
@Transactional(Transactional.TxType.REQUIRED)
@RequestMapping("/api/transaction")
public class CCTransactionsController {

    @Autowired
    private CreditCardTransactionService service;

    @GetMapping()
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

    @GetMapping(value = "/{id}", produces ={MediaType.APPLICATION_JSON_VALUE})
    public CreditCardTransaction getTransactionById( @PathVariable Integer id) {
        return service.getTransactionById(id);
    }

    @PostMapping()
    public String addTransaction(@RequestBody CreditCardTransaction newTransaction) {
        Integer newId = service.addTransaction(newTransaction);
        return ("{id:" + newId + "}");
    }

    @PutMapping("/{id}")
    public void updateTransaction(@PathVariable Integer id,
                                  @RequestBody CreditCardTransaction updatedTransaction) {
        service.updateTransaction(id, updatedTransaction);
    }

}
