package com.multicode.payments.control;

import com.multicode.payments.domain.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class HealthCheckController {

    @GetMapping("/health")
    public String systemIsHealthy() {
        return "ok";
    }

    @GetMapping("/sample")
    public CreditCardTransaction sample() {
        CreditCardTransaction ccTransaction = new CreditCardTransaction();
        ccTransaction.setAmount(23.50);
        ccTransaction.setCountry("USA");
        ccTransaction.setCurrency("USD");
        ccTransaction.setDate(new java.sql.Date(System.currentTimeMillis()));
        return ccTransaction;
    }
}
