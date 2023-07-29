package com.cts.InstallmentCalculatorManagement.entities;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "loanAppDetailMaster")
public class LoanAppDetailMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "loanAppId")
    private LoanAppMaster loanAppMaster;

    @Column(name = "monthNo")
    private int monthNo;

    @Column(name = "installment")
    private int installment;

    @Column(name = "interestRate")
    private int interestRate;

    @Column(name = "pOutStandingBeginOfMon")
    private int pOutStandingBeginOfMon;

    @Column(name = "pRepayment")
    private int pRepayment;

    @Column(name = "prOutStandingEndOfMon")
    private int prOutStandingEndOfMon;

    @Column(name = "lastDateofinstallPay")
    @Temporal(TemporalType.DATE)
    private Date lastDateofinstallPay;

    // Getter and Setter for 'id' field
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// Getter and Setter for 'loanAppMaster' field
	public LoanAppMaster getLoanAppMaster() {
		return loanAppMaster;
	}

	public void setLoanAppMaster(LoanAppMaster loanAppMaster) {
		this.loanAppMaster = loanAppMaster;
	}

	// Getter and Setter for 'monthNo' field
	public int getMonthNo() {
		return monthNo;
	}

	public void setMonthNo(int monthNo) {
		this.monthNo = monthNo;
	}

	// Getter and Setter for 'installment' field
	public int getInstallment() {
		return installment;
	}

	public void setInstallment(int installment) {
		this.installment = installment;
	}

	// Getter and Setter for 'interestRate' field
	public int getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(int interestRate) {
		this.interestRate = interestRate;
	}

	// Getter and Setter for 'pOutStandingBeginOfMon' field
	public int getpOutStandingBeginOfMon() {
		return pOutStandingBeginOfMon;
	}

	public void setpOutStandingBeginOfMon(int pOutStandingBeginOfMon) {
		this.pOutStandingBeginOfMon = pOutStandingBeginOfMon;
	}

	// Getter and Setter for 'pRepayment' field
	public int getpRepayment() {
		return pRepayment;
	}

	public void setpRepayment(int pRepayment) {
		this.pRepayment = pRepayment;
	}

	// Getter and Setter for 'prOutStandingEndOfMon' field
	public int getPrOutStandingEndOfMon() {
		return prOutStandingEndOfMon;
	}

	public void setPrOutStandingEndOfMon(int prOutStandingEndOfMon) {
		this.prOutStandingEndOfMon = prOutStandingEndOfMon;
	}

	// Getter and Setter for 'lastDateofinstallPay' field
	public Date getLastDateofinstallPay() {
		return lastDateofinstallPay;
	}

	public void setLastDateofinstallPay(Date lastDateofinstallPay) {
		this.lastDateofinstallPay = lastDateofinstallPay;
	}

	// Default constructor
	public LoanAppDetailMaster() {
		super();
	}

	// Parameterized constructor
	public LoanAppDetailMaster(int id, LoanAppMaster loanAppMaster, int monthNo, int installment, int interestRate,
			int pOutStandingBeginOfMon, int pRepayment, int prOutStandingEndOfMon, Date lastDateofinstallPay) {
		super();
		this.id = id;
		this.loanAppMaster = loanAppMaster;
		this.monthNo = monthNo;
		this.installment = installment;
		this.interestRate = interestRate;
		this.pOutStandingBeginOfMon = pOutStandingBeginOfMon;
		this.pRepayment = pRepayment;
		this.prOutStandingEndOfMon = prOutStandingEndOfMon;
		this.lastDateofinstallPay = lastDateofinstallPay;
	}

	// toString method to represent the object as a string
	@Override
	public String toString() {
		return "LoanAppDetailMaster [id=" + id + ", loanAppMaster=" + loanAppMaster + ", monthNo=" + monthNo
				+ ", installment=" + installment + ", interestRate=" + interestRate + ", pOutStandingBeginOfMon="
				+ pOutStandingBeginOfMon + ", pRepayment=" + pRepayment + ", prOutStandingEndOfMon="
				+ prOutStandingEndOfMon + ", lastDateofinstallPay=" + lastDateofinstallPay + "]";
	}

	public int getPOutStandingBeginOfMon() {
		// TODO Auto-generated method stub
		return 0;
	}
    
}
