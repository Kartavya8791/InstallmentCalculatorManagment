package com.cts.InstallmentCalculatorManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.InstallmentCalculatorManagement.entities.LoanAppMaster;

@Repository
public interface LoanAppMasterRepository extends JpaRepository<LoanAppMaster, Integer> {
	
}