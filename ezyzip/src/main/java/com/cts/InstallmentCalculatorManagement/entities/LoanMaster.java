package com.cts.InstallmentCalculatorManagement.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "LoanMaster")
public class LoanMaster {

    // Enum to represent different types of loans
    public enum LoanType {
        PERSONAL_LOAN,
        AUTO_LOAN,
        HOME_LOAN,
        BUSINESS_LOAN
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loanId")
    private int loanId;

    @Column(name = "typeofloan")
    @Enumerated(EnumType.STRING)
    private LoanType typeofloan;

    @Column(name = "interestRate")
    private int interestRate;

    @Column(name = "dateOfCreation")
    @Temporal(TemporalType.DATE)
    private Date dateOfCreation;

    // Getter and setter methods for loanId
    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    // Getter and setter methods for typeofloan
    public LoanType getTypeofloan() {
        return typeofloan;
    }

    public void setTypeofloan(LoanType typeofloan) {
        this.typeofloan = typeofloan;
    }

    // Getter and setter methods for interestRate
    public int getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(int interestRate) {
        this.interestRate = interestRate;
    }

    // Getter and setter methods for dateOfCreation
    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    // Default constructor
    public LoanMaster() {
        super();
    }

    // Parameterized constructor
    public LoanMaster(int loanId, LoanType typeofloan, int interestRate, Date dateOfCreation) {
        super();
        this.loanId = loanId;
        this.typeofloan = typeofloan;
        this.interestRate = interestRate;
        this.dateOfCreation = dateOfCreation;
    }

    // toString method to represent the object as a string
    @Override
    public String toString() {
        return "LoanMaster [loanId=" + loanId + ", typeofloan=" + typeofloan + ", interestRate=" + interestRate
                + ", dateOfCreation=" + dateOfCreation + "]";
    }

    // PrePersist method to check the date of creation before persisting the entity
    @PrePersist
    private void checkDateOfCreation() {
        if (dateOfCreation != null && dateOfCreation.before(new Date())) {
            throw new IllegalArgumentException("Date of creation cannot be earlier than the current date.");
        }
    }

}
