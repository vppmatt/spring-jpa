package com.allstate.policies.service;

import com.allstate.policies.data.InsurancePolicyRepository;
import com.allstate.policies.domain.InsurancePolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsurancePolicyServiceImpl implements InsurancePolicyService {

    @Autowired
    private InsurancePolicyRepository insurancePolicyRepository;

    @Override
    public Integer save(InsurancePolicy newPolicy) {
        insurancePolicyRepository.save(newPolicy);
        return newPolicy.getPolicyNo();
    }

    @Override
    public List<InsurancePolicy> getAll() {
        return insurancePolicyRepository.findAll();
    }
}
