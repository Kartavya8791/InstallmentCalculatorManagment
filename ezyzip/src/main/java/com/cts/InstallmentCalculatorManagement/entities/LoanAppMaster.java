package com.cts.InstallmentCalculatorManagement.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "loanAppMaster")
public class LoanAppMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "loanAppid")
	private int loanAppid;

	@Column(name = "interestRate")
	private int interestRate;

	@Column(name = "applicationDate")
	@Temporal(TemporalType.DATE)
	private Date applicationDate;

	// Getter for loanAppid
	public int getLoanAppid() {
		return loanAppid;
	}

	// Setter for loanAppid
	public void setLoanAppid(int loanAppid) {
		this.loanAppid = loanAppid;
	}

	// Getter for interestRate
	public int getInterestRate() {
		return interestRate;
	}

	// Setter for interestRate
	public void setInterestRate(int interestRate) {
		this.interestRate = interestRate;
	}

	// Getter for applicationDate
	public Date getApplicationDate() {
		return applicationDate;
	}

	// Setter for applicationDate
	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}

	// Default constructor
	public LoanAppMaster() {
		super();
	}

	// Parameterized constructor
	public LoanAppMaster(int loanAppid, int interestRate, Date applicationDate) {
		super();
		this.loanAppid = loanAppid;
		this.interestRate = interestRate;
		this.applicationDate = applicationDate;
	}

	// toString method to represent the object as a string
	@Override
	public String toString() {
		return "LoanAppMaster [loanAppid=" + loanAppid + ", interestRate=" + interestRate + ", applicationDate="
				+ applicationDate + "]";
	}	
}
