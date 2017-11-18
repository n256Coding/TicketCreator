package com.csse.ticketcreator.Models;

import com.csse.ticketcreator.Helpers.DatabaseHelper;

/**
 * @author Nishan
 * @version 2.0
 */

public class Account {
    private double amount;
    private String cardHolderName;
    private String cardNumber;
    private String expiryDate;
    private String ccv;
    private String paymentType;

    public Account() {

    }

    public Account(double amount, String cardHolderName, String cardNumber, String expiryDate, String ccv) {
        this.amount = amount;
        this.cardHolderName = cardHolderName;
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.ccv = ccv;
    }

    public double getCashServiceCharge() {
        return 35;
    }

    public double getTotalCharge() {
        if(paymentType.equalsIgnoreCase("cash"))
            return getCashServiceCharge() + amount;
        else
            return amount;
    }

    public String createAccount(User user) {
        DBModel dbModel = new DBModel();
        dbModel.setAmount(amount);
        dbModel.setFname(user.getFirstName());
        dbModel.setLname(user.getLastName());
        dbModel.setContactNo(user.getContactNo());
        dbModel.setNIC(user.getNicNo());

        DatabaseHelper database = new DatabaseHelper();
        database.insertUser(dbModel);
        return database.getCardId();
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getCcv() {
        return ccv;
    }

    public void setCcv(String ccv) {
        this.ccv = ccv;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
}
