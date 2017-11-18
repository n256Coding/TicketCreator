package com.csse.ticketcreator.Controllers;

import com.csse.ticketcreator.Dummies.BankSystemImpl;
import com.csse.ticketcreator.Interfaces.BankSystem;
import com.csse.ticketcreator.Models.Account;

/**
 * This is the controller of the accounts.
 *
 * @author Nishan
 * @version 2.7
 */

public class AccountController {
    private static volatile AccountController accountController = new AccountController();
    private BankSystem bank = new BankSystemImpl();
    private Account account = new Account();
    private String transactionId = null;

    private AccountController() {

    }

    public static AccountController getInstance() {
        return accountController;
    }

    public void resetInstance() {
        account = new Account();
        transactionId = null;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return this.account;
    }

    /**
     * @param holderName bank registered name of the owner of card
     * @param cardNumber credit card number
     * @param expiryDate expiry date of the credit card
     * @param ccv        ccv number of the credit card
     * @return a string which has three status.
     * success          - payment is successfully done.
     * bank_rejected    - card information is correct, but bank rejected the transaction. May be out of credit in bank account.
     * invalid_card     - bank says that card information is invalid.
     */
    public String checkCardDetails(String holderName, String cardNumber, String expiryDate, String ccv) {

        //Check validity of credit card information
        if (bank.validateCardInfo(holderName, cardNumber, expiryDate, ccv)) {

            //Make transaction
            if (bank.makeTransaction(cardNumber, ccv, expiryDate)) {
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
     * @return true if account creation is successful. false otherwise
     */
    public boolean makeAccount() {
        this.transactionId = account.createAccount(UserController.getInstance().getUser());
        return this.transactionId != null;
    }

    public String getTransactionId() {
        return this.transactionId;
    }

    public double getTotalCharge() {
        return account.getTotalCharge();
    }

    public double getCashServiceCharge() {
        return account.getCashServiceCharge();
    }

    public void setPaymentType(String type) {
        account.setPaymentType(type);
    }
}
