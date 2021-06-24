package com.allstate.policies.service;

import com.allstate.policies.domain.InsurancePolicy;

import java.util.List;

public interface InsurancePolicyService {

    public Integer save(InsurancePolicy newPolicy);

    public List<InsurancePolicy> getAll();
}
