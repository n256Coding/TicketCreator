package com.csse.ticketcreator.Dummies;

import com.csse.ticketcreator.Interfaces.BankSystem;

/**
 * Created by Nishan on 11/15/2017.
 */

public class BankSystemImpl implements BankSystem {
    @Override
    public boolean validateCardInfo(String holderName, String cardNumber, String expiryDate, String ccv) {
        if(cardNumber.isEmpty() && ccv.isEmpty()){
            return false;
        }else{
            return true;
        }
    }
}
