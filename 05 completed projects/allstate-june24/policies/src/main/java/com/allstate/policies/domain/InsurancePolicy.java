package com.allstate.policies.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InsurancePolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer policyNo;
    private String customerName;
    private Double amountInsured;

    public Integer getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(Integer policyNo) {
        this.policyNo = policyNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Double getAmountInsured() {
        return amountInsured;
    }

    public void setAmountInsured(Double amountInsured) {
        this.amountInsured = amountInsured;
    }

    @Override
    public String toString() {
        return "InsurancePolicy{" +
                "policyNo=" + policyNo +
                ", customerName='" + customerName + '\'' +
                ", amountInsured=" + amountInsured +
                '}';
    }
}
