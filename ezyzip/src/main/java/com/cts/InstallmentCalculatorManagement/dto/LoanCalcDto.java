package com.cts.InstallmentCalculatorManagement.dto;

public class LoanCalcDto {
	double principal;
	double intrest;
	int tenure;
	public LoanCalcDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoanCalcDto(double principal, double intrest, int tenure) {
		super();
		this.principal = principal;
		this.intrest = intrest;
		this.tenure = tenure;
	}
	public double getPrincipal() {
		return principal;
	}
	public void setPrincipal(double principal) {
		this.principal = principal;
	}
	public double getIntrest() {
		return intrest;
	}
	public void setIntrest(double intrest) {
		this.intrest = intrest;
	}
	public int getTenure() {
		return tenure;
	}
	public void setTenure(int tenure) {
		this.tenure = tenure;
	}
	@Override
	public String toString() {
		return "LoanCalcDto [principal=" + principal + ", intrest=" + intrest + ", tenure=" + tenure + "]";
	}
	
}
