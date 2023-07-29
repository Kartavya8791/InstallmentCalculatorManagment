package com.cts.InstallmentCalculatorManagement;

import java.util.Date;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cts.InstallmentCalculatorManagement.entities.LoanAppDetailMaster;
import com.cts.InstallmentCalculatorManagement.services.LoanService;

@SpringBootApplication
public class InstallmentCalculatorManagementApplication {

	public static void main(String[] args) {
		// The following line starts the Spring Boot application
		SpringApplication.run(InstallmentCalculatorManagementApplication.class, args);
		
		
	}
}
