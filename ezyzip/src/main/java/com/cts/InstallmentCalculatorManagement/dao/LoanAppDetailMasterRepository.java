package com.cts.InstallmentCalculatorManagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.InstallmentCalculatorManagement.entities.LoanAppDetailMaster;


@Repository
public interface LoanAppDetailMasterRepository extends JpaRepository<LoanAppDetailMaster, Integer> {

	List<LoanAppDetailMaster> findByLoanAppMasterLoanAppid(int loanAppId);
}