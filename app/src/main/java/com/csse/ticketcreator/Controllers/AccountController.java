package com.csse.ticketcreator.Controllers;

import com.csse.ticketcreator.Models.Account;

/**
 * @author Nishan
 * @version 1.0
 */

public class AccountController {
    private static volatile AccountController accountController = new AccountController();
    private Account account;

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
}
