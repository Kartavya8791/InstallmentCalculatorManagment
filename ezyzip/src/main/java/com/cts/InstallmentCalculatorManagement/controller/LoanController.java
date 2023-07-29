package com.cts.InstallmentCalculatorManagement.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.InstallmentCalculatorManagement.dto.LoanCalcDto;
import com.cts.InstallmentCalculatorManagement.entities.LoanAppDetailMaster;
import com.cts.InstallmentCalculatorManagement.entities.LoanMaster;
import com.cts.InstallmentCalculatorManagement.services.LoanService;

@CrossOrigin
@RestController
@RequestMapping("/api/loan")
public class LoanController {
	
	@Autowired
    private LoanService loanService;

    
    @GetMapping("/home")
	public String home() {
		return "Welcome to Installment calculator management Home Page";
	}

    // end point 1
    @CrossOrigin
    @PostMapping("/new")
    public ResponseEntity<String> addNewLoan(@RequestBody LoanMaster loanMaster) {
        // Call the loan service to add the new loan type
        loanService.insertNewLoan(loanMaster);
        
        return ResponseEntity.ok("Loan type added successfully");
    }
    
    // end point 2
    @GetMapping("/{loanId}")
    public LoanMaster getLoanTypeOfLoan(@PathVariable int loanId) {
    	return loanService.getLoansByType(loanId);
    }
    
    // end point 3
    @CrossOrigin
    @PutMapping("{loanId}/update")
    public ResponseEntity<String> updateLoanMaster(@PathVariable int loanId, @RequestBody LoanMaster loanMaster) {
    	loanService.updateLoanInformation(loanId, loanMaster);
    	return ResponseEntity.ok("Loan type updated successfully");
    }
    
    // end point 4
    @GetMapping
    public List<String> getUniqueLoans() {
    	return loanService.getUniqueTypeOfLoans();
    }
    
    //end point 5
    @PostMapping("emicalc")
    public double emiCalculaterInstallment(@RequestBody LoanCalcDto loanDto) {
    	return loanService.calculateInstallment(loanDto.getPrincipal(), loanDto.getTenure(), loanDto.getIntrest());
    }
}
