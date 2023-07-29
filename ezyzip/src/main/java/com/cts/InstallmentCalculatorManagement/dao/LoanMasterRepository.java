package com.cts.InstallmentCalculatorManagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.InstallmentCalculatorManagement.entities.LoanMaster;
import com.cts.InstallmentCalculatorManagement.entities.LoanMaster.LoanType;

@Repository
public interface LoanMasterRepository extends JpaRepository<LoanMaster, Integer> {

	List<LoanMaster> findByTypeofloan(String valueOf);
	LoanMaster findFirstByTypeofloanOrderByDateOfCreationDesc(LoanType loanType);
	@Query("select distinct c.typeofloan from LoanMaster c")
	List<String> getUniqueLoanTypes();
}