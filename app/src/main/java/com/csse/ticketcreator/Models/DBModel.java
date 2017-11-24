package com.csse.ticketcreator.Models;

/**
 * This class represent travel card information.
 * This is used to map java data into firebase database.
 *
 * @author Nishan
 * @version 1.5
 */

public class DBModel {
    private String firstName;
    private String lastName;
    private String ContactNo;
    private String NIC;
    private double Amount;
    private double Loan = 0;
    private String LoanFlag = "false";
    private String RideFlag = "false";

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContactNo() {
        return ContactNo;
    }

    public void setContactNo(String contactNo) {
        this.ContactNo = contactNo;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        this.Amount = amount;
    }

    public double getLoan() {
        return Loan;
    }

    public void setLoan(double loan) {
        Loan = loan;
    }

    public String getLoanFlag() {
        return LoanFlag;
    }

    public void setLoanFlag(String loanFlag) {
        LoanFlag = loanFlag;
    }

    public String getRideFlag() {
        return RideFlag;
    }

    public void setRideFlag(String rideFlag) {
        RideFlag = rideFlag;
    }
}
