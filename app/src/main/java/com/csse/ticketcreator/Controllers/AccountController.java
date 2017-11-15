package com.csse.ticketcreator.Controllers;

import com.csse.ticketcreator.Dummies.BankSystemImpl;
import com.csse.ticketcreator.Interfaces.BankSystem;
import com.csse.ticketcreator.Models.Account;

/**
 * @author Nishan
 * @version 1.0
 */

public class AccountController {
    private static volatile AccountController accountController = new AccountController();
    private BankSystem bank = new BankSystemImpl();
    private Account account;
    private String transactionId;

    private AccountController(){

    }

    public static AccountController getInstance(){
        return accountController;
    }

    public void setAccount(Account account){
        this.account = account;
    }

    public Account getAccount(){
        if(account == null)
            account = new Account();
        return this.account;
    }

    public boolean checkCardDetails(String holderName, String cardNumber, String expiryDate, String ccv){
        return bank.validateCardInfo(holderName, cardNumber, expiryDate, ccv);
    }

    public String makeAccount(){
        this.transactionId = account.createAccount(UserController.getInstance().getUser());
        return this.transactionId;
    }

    public String getTransactionId(){
        return this.transactionId;
    }

    public double getTotalCharge(){
        return account.getTotalCharge();
    }

    public void setPaymentType(String type){
        account.setPaymentType(type);
    }
}
