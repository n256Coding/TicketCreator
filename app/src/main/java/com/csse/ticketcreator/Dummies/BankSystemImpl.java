package com.csse.ticketcreator.Dummies;

/**
 * Dummy class represent to Real Bank System
 *
 * @author Nishan
 * @version 1.0
 */

public class BankSystemImpl implements BankSystem {
    @Override
    public boolean validateCardInfo(String holderName, String cardNumber, String expiryDate, String ccv) {
        if (cardNumber.isEmpty() && ccv.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean makeTransaction(String cardNumber, String ccv, String expiryDate) {
        return true;
    }
}
