package com.csse.ticketcreator.Controllers;

import com.csse.ticketcreator.Dummies.BankSystem;
import com.csse.ticketcreator.Dummies.BankSystemImpl;
import com.csse.ticketcreator.Models.TravelCard;

/**
 * This is the controller of the travel card creation and
 * coordinates the travel card creation process. This will also stores information
 * which requires for that process.
 *
 * @author Nishan
 * @version 2.7
 */

public class AccountController {
    private static volatile AccountController accountController = new AccountController();
    private BankSystem bank = new BankSystemImpl();
    private TravelCard travelCard = new TravelCard();
    private String transactionId = null;

    private AccountController() {

    }

    /**
     * This method will return single instance when needed.
     *
     * @return AccountController instance
     */
    public static AccountController getInstance() {
        return accountController;
    }

    public void resetInstance() {
        travelCard = new TravelCard();
        transactionId = null;
    }


    /**
     * This method will verify information of Credit card before actual payment.
     * This will send credit card information to bank to verify details.
     *
     * @param creditCard object contains information of travel card
     * @return a string which has three status.
     * success          - payment is successfully done.
     * bank_rejected    - card information is correct, but bank rejected the transaction. May be out of credit in bank creditCard.
     * invalid_card     - bank says that card information is invalid.
     */
    public String verifyCreditCardForPayments(TravelCard creditCard) {

        //Check validity of credit card information
        if (bank.validateCardInfo(creditCard.getCreditCardHolderName(), creditCard.getCreditCardNumber(),
                creditCard.getCreditCardExpiryDate(), creditCard.getCreditCardCcv())) {

            //Make transaction
            if (bank.makeTransaction(creditCard.getCreditCardNumber(), creditCard.getCreditCardCcv(), creditCard.getCreditCardExpiryDate())) {
                return "success";
            } else {
                return "bank_rejected";
            }
        } else {
            return "invalid_card";
        }
    }

    /**
     * Make a travel card with user given information.
     *
     * @return true if travelCard creation is successful. false otherwise
     */
    public boolean makeTravelCard() {
        this.transactionId = travelCard.createTravelCard(UserController.getInstance().getUser());
        return this.transactionId != null;
    }

    /**
     * Update travel card amount
     *
     * @param travelCardRef reference of travel card to be updated
     * @param newAmount     new amount of travel card
     * @return true if travelCard updating is successful. false otherwise
     */
    public boolean updateTravelCard(String travelCardRef, Double newAmount) {
        this.transactionId = travelCard.updateTravelCardAmount(travelCardRef, newAmount);
        return this.transactionId != null;
    }

    public void setTravelCardInformation(TravelCard travelCard) {
        this.travelCard = travelCard;
    }

    public TravelCard getTravelCard() {
        return this.travelCard;
    }

    public String getTransactionId() {
        return this.transactionId;
    }

    public double getTotalCharge() {
        return travelCard.getTotalCharge();
    }

    public double getCashServiceCharge() {
        return travelCard.getCashServiceCharge();
    }

    public void setPaymentType(String type) {
        travelCard.setPaymentType(type);
    }
}
