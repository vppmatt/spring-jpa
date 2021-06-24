package com.allstate.policies.control;

import com.allstate.policies.domain.InsurancePolicy;
import com.allstate.policies.service.InsurancePolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/policy")
public class InsurancePolicyController {

    @Autowired
    private InsurancePolicyService service;

//    @GetMapping("/api/policy")
//    public String defaultMethod() {
//        InsurancePolicy policy1 = new InsurancePolicy();
//        policy1.setAmountInsured(1000.00);
//        policy1.setCustomerName("Matt");
//
//        InsurancePolicy policy2 = new InsurancePolicy();
//        policy2.setAmountInsured(160.99);
//        policy2.setCustomerName("Sue");
//
//        service.save(policy1);
//        service.save(policy2);
//
//        return "ok";
//    }

    @GetMapping()
    public List<InsurancePolicy> getAll() {
        return service.getAll();
    }

}
