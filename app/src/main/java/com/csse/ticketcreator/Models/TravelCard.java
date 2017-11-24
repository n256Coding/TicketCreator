package com.csse.ticketcreator.Models;

import com.csse.ticketcreator.Helpers.DatabaseHelper;

/**
 * This class represent travel card which going to create. It will store attributes
 * and operations related to travel card.
 *
 * @author Nishan
 * @version 2.4
 */

public class TravelCard {
    private String creditCardHolderName = "";
    private String creditCardNumber = "";
    private String creditCardExpiryDate = "";
    private String creditCardCcv = "";
    private double amount = 0;
    private String paymentType = "";
    private User user = new User();


    /**
     * This method will return service charge for cash transactions
     *
     * @return service charge value
     */
    public double getCashServiceCharge() {
        return 35;
    }

    /**
     * This will calculate total charge for creation of travel card. It will check payment type
     * and return correct total charge
     *
     * @return total charge which taken from user
     */
    public double getTotalCharge() {
        if (paymentType.equalsIgnoreCase("cash"))
            return getCashServiceCharge() + amount;
        else
            return amount;
    }

    /**
     * This method will Initiate travel card creation process.
     *
     * @param user information of user taken from {@link com.csse.ticketcreator.Fragments.PersonalInfoFragment}
     * @return a string contain ID of created travel card
     */
    public String createTravelCard(User user) {
        DBModel DBModel = new DBModel();
        DBModel.setAmount(amount);
        DBModel.setFirstName(user.getFirstName());
        DBModel.setLastName(user.getLastName());
        DBModel.setContactNo(user.getContactNo());
        DBModel.setNIC(user.getNicNo());

        DatabaseHelper database = new DatabaseHelper();
        database.insertTravelCard(DBModel);
        return database.getCardId();
    }

    public String updateTravelCardAmount(String travelCardRef, Double newAmount){
        DatabaseHelper databaseHelper = new DatabaseHelper();
        databaseHelper.updateTravelAmount(travelCardRef, newAmount);
        return databaseHelper.getCardId();
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCreditCardHolderName() {
        return creditCardHolderName;
    }

    public void setCreditCardHolderName(String creditCardHolderName) {
        this.creditCardHolderName = creditCardHolderName;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCreditCardExpiryDate() {
        return creditCardExpiryDate;
    }

    public void setCreditCardExpiryDate(String creditCardExpiryDate) {
        this.creditCardExpiryDate = creditCardExpiryDate;
    }

    public String getCreditCardCcv() {
        return creditCardCcv;
    }

    public void setCreditCardCcv(String creditCardCcv) {
        this.creditCardCcv = creditCardCcv;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public void setUser(User user){
        this.user = user;
    }

    public User getUser(){
        return this.user;
    }
}
