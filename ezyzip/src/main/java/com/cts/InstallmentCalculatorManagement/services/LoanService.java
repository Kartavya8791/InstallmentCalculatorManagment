package com.cts.InstallmentCalculatorManagement.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.InstallmentCalculatorManagement.dao.LoanAppDetailMasterRepository;
import com.cts.InstallmentCalculatorManagement.dao.LoanAppMasterRepository;
import com.cts.InstallmentCalculatorManagement.dao.LoanMasterRepository;
import com.cts.InstallmentCalculatorManagement.entities.LoanAppDetailMaster;
import com.cts.InstallmentCalculatorManagement.entities.LoanMaster;

@Service // Indicates that this class is a service component
public class LoanService {

	@Autowired // Injects the LoanMasterRepository bean into the class
	private LoanMasterRepository loanMasterRepository;

	@Autowired // Injects the LoanAppMasterRepository bean into the class
	private LoanAppMasterRepository loanAppMasterRepository;

	@Autowired // Injects the LoanAppDetailMasterRepository bean into the class
	private LoanAppDetailMasterRepository loanAppDetailMasterRepository;

	// Inserts a new loan into the repository
	public void insertNewLoan(LoanMaster loan) {
		loanMasterRepository.save(loan);
	}

	// Retrieves a loan by loanId
	public LoanMaster getLoansByType(int loanId) {
		return loanMasterRepository.findById(loanId).get();
	}

	// Updates the loan information for the given loanId
	public void updateLoanInformation(int loanId, LoanMaster updatedLoan) {
		LoanMaster loan = loanMasterRepository.findById(loanId).orElse(null);
		if (loan != null) {
			// Update the loan information based on the provided loanId
			// Perform any necessary validations or calculations before saving the updated loan		
			updatedLoan.setLoanId(loanId);
			loanMasterRepository.save(updatedLoan);
		}
	}

	// Retrieves a list of unique loan types
	public List<String> getUniqueTypeOfLoans() {
		return loanMasterRepository.getUniqueLoanTypes();
	}

	// Calculates the installment amount for a loan
	public double calculateInstallment(double principalLoanAmount, int loanTenureMonths, double monthlyInterestRate) {
		// Calculate the loan installment based on the provided parameters
		monthlyInterestRate = monthlyInterestRate / 1200;
		return (principalLoanAmount * monthlyInterestRate * Math.pow((1 + monthlyInterestRate),loanTenureMonths) / (Math.pow(1+monthlyInterestRate, loanTenureMonths)-1));
	}

	// Generates a list of reduced payment installments for a loan application
	public List<LoanAppDetailMaster> reducedPayment(int loanAppId, int principalLoanAmount, double intrest, int tenure,
			Date startDate) {

		List<LoanAppDetailMaster> installmentList = new ArrayList<>();
		int installment = (int) Math.round(calculateInstallment(principalLoanAmount, tenure, intrest));

		for(int i=1;i<=tenure;i++) {
			LoanAppDetailMaster obj = new LoanAppDetailMaster();
			obj.setMonthNo(i);
			obj.setInstallment(installment);
			
			int intrestComponent = (int) ((intrest / 100) * principalLoanAmount)/12;
			int principalComponent = installment - intrestComponent;

			obj.setId(loanAppId);
			startDate = addMonths(startDate,1);
			obj.setLastDateofinstallPay(startDate);
			obj.setpOutStandingBeginOfMon(principalLoanAmount);
			principalLoanAmount -= principalComponent;
			obj.setInterestRate(intrestComponent);
			obj.setpRepayment(principalComponent);
			obj.setPrOutStandingEndOfMon(principalLoanAmount);
			
			installmentList.add(obj);
		}
		
		return loanAppDetailMasterRepository.saveAll(installmentList);
	}
	
	// Adds months to a given date
	public static java.util.Date addMonths(java.util.Date today,
            int monthsToAdd) {
        if (today != null) {
            java.util.Calendar c = java.util.Calendar.getInstance();
            c.setTime(today);
            c.add(Calendar.MONTH, monthsToAdd);
            return c.getTime();
        } else {
            return null;
        }
    }
	
}
